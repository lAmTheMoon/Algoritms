package yandex.Item2.sprint2.finalTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {

    public static final String PUSH_FRONT = "push_front";
    public static final String PUSH_BACK = "push_back";
    public static final String POP_FRONT = "pop_front";
    public static final String POP_BACK = "pop_back";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int commandCount = Integer.parseInt(reader.readLine());
            int dequeCapacity = Integer.parseInt(reader.readLine());
            String[] commands = new String[commandCount];
            for (int i = 0; i < commandCount; i++) {
                commands[i] = reader.readLine();
            }
            printResult(dequeCapacity, commands);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printResult(int dequeCapacity, String[] commands) {
        MyQueue<String> queue = new MyQueue<>(dequeCapacity);
        for (String command : commands) {
            if (command.startsWith(PUSH_FRONT)){
                queue.push_front(getValue(command));
            } else if (command.startsWith(PUSH_BACK)){
                queue.push_back(getValue(command));
            } else if (POP_FRONT.equals(command)){
                queue.pop_front();
            } else if (POP_BACK.equals(command)){
                queue.pop_back();
            } else {
                throw new UnsupportedOperationException();
            }
        }
    }

    private static String getValue(String command) {
        return command.split(" ")[1];
    }
}

class MyQueue<T> implements Deque<T> {

    private static final String ERROR = "error";

    private final int capacity;

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;


    public MyQueue(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public void push_front(T value) {
        if (isFull()) {
            System.out.println(ERROR);
            return;
        }
        if (isEmpty()) {
            head = new Node<>(value, null, null);
            tail = head;
        } else {
            Node<T> newNode = new Node<>(value, head, null);
            if (tail == head) {
                tail.previous = newNode;
            }
            head.previous = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void push_back(T value) {
        if (isFull()) {
            System.out.println(ERROR);
            return;
        }
        if (isEmpty()) {
            head = new Node<>(value, null, null);
            tail = head;
        } else {
            Node<T> newNode = new Node<>(value, null, tail);
            if (tail == head) {
                head.next = newNode;
            }
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void pop_front() {
        if (isEmpty()) {
            System.out.println(ERROR);
        } else {
            System.out.println(head.value);
            head = head.next;
            if (head != null) {
                head.previous = null;
            }
            size--;
        }
    }

    @Override
    public void pop_back() {
        if (isEmpty()) {
            System.out.println(ERROR);
        } else {
            System.out.println(tail.value);
            tail = tail.previous;
            if (tail != null) {
                tail.next = null;
            }
            size--;
        }
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == capacity;
    }

    private static class Node<V> {
        private final V value;
        private Node<V> next;
        private Node<V> previous;

        public Node(V value, Node<V> next, Node<V> previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
    }
}

interface Deque<T> {

    void pop_front();

    void pop_back();

    void push_front(T value);

    void push_back(T value);
}
