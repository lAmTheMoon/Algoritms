package yandex.Item2.sprint2.finalTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ID посылки 88415698
 * <p>
 * Реализация на деке с использованием кругового массива, очередь хранит индекс первого и последнего эл-ов
 * Все методы работают за О(1)
 * При добавлении эл-та в начало очереди, сохраняем в head индекс эл-та, если это первый эл-т, то tail = head,
 * аналогично при добавлении в конец очереди.
 * При удалении эл-та из начала очереди я присваиваю head предыдущего эл-та, если head == tail, значит,
 * удаляем последний эл-т => head = tail = -1, аналогично для удаления последнего эл-та
 */

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
            if (POP_FRONT.equals(command)) {
                queue.pop_front();
            } else if (POP_BACK.equals(command)) {
                queue.pop_back();
            } else if (command.startsWith(PUSH_FRONT)) {
                queue.push_front(getValue(command));
            } else if (command.startsWith(PUSH_BACK)) {
                queue.push_back(getValue(command));
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
    private final Object[] objects;
    private int head;
    private int tail;
    private int size;

    public MyQueue(int capacity) {
        this.capacity = capacity;
        head = -1;
        tail = -1;
        size = 0;
        objects = new Object[capacity];
    }

    @Override
    public void push_front(T value) {
        if (isFull()) {
            System.out.println(ERROR);
            return;
        }
        if (head == -1) {
            head = 0;
            tail = 0;
        } else if (head == 0) {
            head = capacity - 1;
        } else {
            head = head - 1;
        }
        objects[head] = value;
        size++;
    }

    @Override
    public void push_back(T value) {
        if (isFull()) {
            System.out.println(ERROR);
            return;
        }
        if (tail == -1) {
            head = 0;
            tail = 0;
        } else if (tail == capacity - 1) {
            tail = 0;
        } else {
            tail = tail + 1;
        }
        objects[tail] = value;
        size++;
    }

    @Override
    public void pop_front() {
        if (isEmpty()) {
            System.out.println(ERROR);
        } else {
            System.out.println(objects[head]);
            if (head == tail) {
                head = -1;
                tail = -1;
            } else if (head == capacity - 1) {
                head = 0;
            } else {
                head = head + 1;
            }
            size--;
        }
    }

    @Override
    public void pop_back() {
        if (isEmpty()) {
            System.out.println(ERROR);
        } else {
            System.out.println(objects[tail]);
            if (head == tail) {
                head = -1;
                tail = -1;
            } else if (tail == 0) {
                tail = capacity - 1;
            } else {
                tail = tail - 1;
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
}

interface Deque<T> {

    void pop_front();

    void pop_back();

    void push_front(T value);

    void push_back(T value);
}
