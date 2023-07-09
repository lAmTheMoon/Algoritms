package yandex.Item2.sprint4.finalTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
        MyMap<String, String> map = new MyMap<>();
        for (String command : commands) {
            if (command.startsWith(GET)) {
                map.get(getValue(command)[1]);
            } else if (command.startsWith(PUT)) {
                String[] entry = getValue(command);
                map.put(entry[1], entry[2]);
            } else if (command.startsWith(DELETE)) {
                map.delete(getValue(command)[1]);
            } else {
                throw new UnsupportedOperationException();
            }
        }
    }

    private static String[] getValue(String command) {
        return command.split(" ");
    }
}

class MyMap<K, V> implements Map<K, V> {

    private static final int CAPACITY = 100000;

    private final Entry<K, V>[] entry = new Entry[CAPACITY];

    @Override
    public void put(K k, V v) {
        Entry<K, V>[] e = getEntryPairIfIsExist(k);
        int index = getHash(k);
        if (e.length != 0) {
            Entry<K, V> prev = e[1];
            Entry<K, V> newEntry = new Entry<>(k, v, e[0].getNext());
            if (prev != null) {
                prev.setNext(newEntry);
            }
            entry[index] = newEntry;

        } else {
            entry[index] = new Entry<>(k, v, null);
        }
    }

    @Override
    public void get(K k) {
        Entry<K, V> e = getEntryIfIsExist(k);
        if (e == null) {
            System.out.println("None");
            return;
        }
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
        Entry<K, V>[] e = getEntryPairIfIsExist(k);
        if (e.length == 0) {
            System.out.println("None");
            return;
        }

        Entry<K, V> before = e[1];
        if (before != null) {
            before.setNext(e[0].getNext());
        }
        System.out.println(e[0].getValue());
        if (e[0].getNext() == null) {
            entry[getHash(k)] = null;
        }

    }

    private int getHash(K k) {
        return Math.abs(k.hashCode()) % CAPACITY;
    }

    private Entry<K, V> getEntryIfIsExist(K k) {
        Entry<K, V> e = entry[getHash(k)];
        if (e != null) {
            while (true) {
                if (k.equals(e.getKey())) {
                    return e;
                } else if (e.getNext() == null) {
                    break;
                } else {
                    e = e.getNext();
                }
            }
        }
        return null;
    }

    private Entry<K, V>[] getEntryPairIfIsExist(K k) {
        Entry<K, V> current = entry[getHash(k)];
        if (current != null) {
            Entry<K, V> prew = null;
            while (true) {
                if (k.equals(current.getKey())) {
                    return new Entry[] {current, prew};
                } else if (current.getNext() == null) {
                    break;
                } else {
                    prew = current;
                    current = current.getNext();
                }
            }
        }
        return new Entry[0];
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

    public Entry(K key, V value, Entry<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
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
