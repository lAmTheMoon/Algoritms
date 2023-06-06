package yandex.Item2.sprint2.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Астрологи объявили день очередей ограниченного размера.
Тимофею нужно написать класс MyQueueSized, который принимает параметр max_size,
означающий максимально допустимое количество элементов в очереди.
Помогите ему —– реализуйте программу, которая будет эмулировать работу такой очереди.
Функции, которые надо поддержать, описаны в формате ввода.

Формат ввода
В первой строке записано одно число — количество команд, оно не превосходит 5000.
Во второй строке задан максимально допустимый размер очереди, он не превосходит 5000.
Далее идут команды по одной на строке. Команды могут быть следующих видов:

push(x) — добавить число x в очередь;
pop() — удалить число из очереди и вывести на печать;
peek() — напечатать первое число в очереди;
size() — вернуть размер очереди;
При превышении допустимого размера очереди нужно вывести «error».
При вызове операций pop() или peek() для пустой очереди нужно вывести «None».
 */
public class I {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int size = Integer.parseInt(reader.readLine());
            int queueSize = Integer.parseInt(reader.readLine());
            String[] commands = new String[size];
            for (int i = 0; i < size; i++) {
                commands[i] = reader.readLine();
            }

            printResult(size, queueSize, commands);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printResult(int size, int queueSize, String[] commands) {
        MyQueueSized queueSized = new MyQueueSized(queueSize);
        for (int i = 0; i < size; i++) {
            String command = commands[i];
            switch (command) {
                case ("pop"):
                    queueSized.pop();
                    break;
                case ("peek"):
                    queueSized.peek();
                    break;
                case ("size"):
                    queueSized.size();
                    break;
                default:
                    int number = Integer.parseInt(command.split(" ")[1]);
                    queueSized.push(number);
            }
        }
    }

    private static class MyQueueSized {
        private final int[] queue;
        private final int max_n;
        private int head;
        private int tail;
        private int size;

        public MyQueueSized(int maxSize) {
            queue = new int[maxSize];
            max_n = maxSize;
            head = 0;
            tail = 0;
            size = 0;
        }

        private boolean isEmpty() {
            return size == 0;
        }

        public void push(int x) {
            if (size != max_n) {
                queue[tail] = x;
                tail = (tail + 1) % max_n;
                size++;
            } else {
                System.out.println("error");
            }
        }

        public void peek() {
            if (isEmpty()) {
                System.out.println("None");
            } else {
                System.out.println(queue[head]);
            }
        }

        public void size() {
            System.out.println(size);;
        }

        public void pop() {
            if (isEmpty()) {
                System.out.println("None");
            } else {
                int x = queue[head];
                queue[head] = 0;
                head = (head + 1) % max_n;
                size--;
                System.out.println(x);
            }
        }
    }
}
