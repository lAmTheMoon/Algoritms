package yandex.Item2.sprint4.finalTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B {

    public static final String GET = "get";
    public static final String PUT = "put";
    public static final String DELETE = "delete";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int commandCount = Integer.parseInt(reader.readLine());
            String[] commands = new String[commandCount];
            for (int i = 0; i < commandCount; i++) {
                commands[i] = reader.readLine();
            }
            printResult(commands);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printResult(String[] commands) {
        MyMap<Integer, Integer> map = new MyMap<>();
        for (String command : commands) {
            if (command.startsWith(GET)) {
                map.get(getValue(command)[0]);
            } else if (command.startsWith(PUT)) {
                int[] numbers = getValue(command);
                map.put(numbers[0], numbers[1]);
            } else if (command.startsWith(DELETE)) {
                map.delete(getValue(command)[0]);
            } else {
                throw new UnsupportedOperationException();
            }
        }
    }

    private static int[] getValue(String command) {
        return Arrays.stream(command.split(" "))
                .skip(1)
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}

class MyMap<K, V> implements Map<K, V> {

    private static final int CAPACITY = 100000;

    private final Entry<K, V>[] entry = new Entry[CAPACITY];

    @Override
    public void put(K k, V v) {
        int index = getHash(k);
        if (!keyIsExist(k)) {
            Entry<K, V> e = entry[index];
            if (e != null) {
                while (true) {
                    if (e.getNext() == null) {
                        Entry<K, V> newEntry = new Entry<>(k, v, null, e);
                        e.setNext(newEntry);
                        break;
                    }
                    e = e.getNext();
                }
                return;
            }
        }

        entry[index] = new Entry<>(k, v, null, null);
    }

    @Override
    public void get(K k) {
        if (!entryIsExist(k)) {
            System.out.println("None");
            return;
        }
        Entry<K, V> e = entry[getHash(k)];
        while (true) {
            if (k.equals(e.getKey())) {
                System.out.println(e.getValue());
                break;
            } else if (e.getNext() != null) {
                e = e.getNext();
            }
        }
    }

    @Override
    public void delete(K k) {
        if (!entryIsExist(k)) {
            System.out.println("None");
            return;
        }
        int index = getHash(k);
        Entry<K, V> e = entry[index];
        while (true) {
            if (k.equals(e.getKey())) {
                Entry<K, V> next = e.getNext();
                Entry<K, V> before = e.getBefore();
                if (before != null) {
                    before.setNext(next);
                }
                if (next != null) {
                    next.setBefore(before);
                }
                System.out.println(e.getValue());
                break;
            } else if (e.getNext() != null) {
                e = e.getNext();
            }
        }
        if (e.getNext() == null && e.getBefore() == null) {
            entry[index] = null;
        }
    }

    private int getHash(K k) {
        return Math.abs(k.hashCode()) % CAPACITY;
    }

    private boolean entryIsExist(K k) {
        Entry<K, V> e = entry[getHash(k)];
        if (e != null) {
            while (true) {
                if (k.equals(e.getKey())) {
                    return true;
                } else if (e.getNext() == null) {
                    break;
                } else {
                    e = e.getNext();
                }
            }
        }
        return false;
    }

    private boolean keyIsExist(K k) {
        return entry[getHash(k)] != null;
    }
}

interface Map<K, V> {

    void put(K k, V v);

    void get(K k);

    void delete(K k);
}

class Entry<K, V> {

    private K key;
    private V value;
    private Entry<K, V> next;
    private Entry<K, V> before;

    public Entry(K key, V value, Entry<K, V> next, Entry<K, V> before) {
        this.key = key;
        this.value = value;
        this.next = next;
        this.before = before;
    }

    public Entry<K, V> getBefore() {
        return before;
    }

    public void setBefore(Entry<K, V> before) {
        this.before = before;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Entry<K, V> getNext() {
        return next;
    }

    public void setNext(Entry<K, V> next) {
        this.next = next;
    }
}
