package yandex.Item2.sprint4.finalTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ID посылки 88915968
 *
 * Реализованная мапа представляет собой обертку над массивом длины 10^5, который состоит из объектов Entry.
 * Entry - объект, содержащий объект, который является ключем мапы, и объект, который явсяется значением мапы,
 * также присутствует ссылка на следующий Entry, на случай возникновения коллизии.
 * Коллизии разрешаются методом цепочек.
 * Методы мапы в лучшем случае работают за O(1), в худшем - O(N), где N - кол-во объектов с одинаковым индексом
 */
public class B {

    private static final String GET = "get";
    private static final String PUT = "put";
    private static final String DELETE = "delete";
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int commandCount = Integer.parseInt(reader.readLine());
            MyMap<String, String> map = new MyMap<>();
            for (int i = 0; i < commandCount; i++) {
                String[] entry = reader.readLine().split(" ");
                switch (entry[0]) {
                    case GET:
                        writeResult(map.get(entry[1]));
                        break;
                    case PUT:
                        map.put(entry[1], entry[2]);
                        break;
                    case DELETE:
                        writeResult(map.delete(entry[1]));
                        break;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeResult(String result) {
        sb.append(result);
        sb.append("\n");
    }
}

class MyMap<K, V> implements Map<K, V> {

    private static final int CAPACITY = 100000;
    private static final String NONE = "None";

    private final Entry<K, V>[] entry = new Entry[CAPACITY];

    @Override
    public void put(K k, V v) {
        int index = getIndex(k);
        Entry<K, V>[] e = getEntryPairIfIsExist(k, index);
        if (e.length == 0) {
            entry[index] = new Entry<>(k, v, null);
        } else {
            if (e[0] != null) {
                e[0].setValue(v);
            } else {
                e[1].setNext(new Entry<>(k, v, null));
            }
        }
    }

    @Override
    public String get(K k) {
        Entry<K, V> e = getEntryIfIsExist(k, getIndex(k));
        if (e == null) {
            return NONE;
        }
        return e.getValue().toString();
    }

    @Override
    public String delete(K k) {
        int index = getIndex(k);
        Entry<K, V>[] e = getEntryPairIfIsExist(k, index);
        if (e.length == 0 || e[0] == null) {
            return NONE;
        }

        Entry<K, V> before = e[1];
        if (before != null) {
            before.setNext(e[0].getNext());
        }

        if (k.equals(entry[index].getKey())) {
            entry[index] = null;
        }

        return e[0].getValue().toString();
    }

    private int getIndex(K k) {
        return Math.abs(k.hashCode() % CAPACITY);
    }

    private Entry<K, V> getEntryIfIsExist(K k, int index) {
        Entry<K, V> e = entry[index];
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

    private Entry<K, V>[] getEntryPairIfIsExist(K k, int index) {
        Entry<K, V> current = entry[index];
        if (current != null) {
            Entry<K, V> prew = null;
            while (true) {
                if (k.equals(current.getKey())) {
                    return new Entry[]{current, prew};
                } else if (current.getNext() == null) {
                    return new Entry[]{null, current};
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

    String get(K k);

    String delete(K k);
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
