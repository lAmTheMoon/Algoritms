package yandex.Item2.sprint2.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int size = Integer.parseInt(reader.readLine());
            String[] commands = new String[size];
            for (int i = 0; i < size; i++) {
                commands[i] = reader.readLine();
            }

            printResult(size, commands);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printResult(int size, String[] commands) {
        MyQueue queue = new MyQueue();
        for (int i = 0; i < size; i++) {
            String command = commands[i];
            switch (command) {
                case ("get"):
                    queue.get();
                    break;
                case ("size"):
                    queue.size();
                    break;
                default:
                    int number = Integer.parseInt(command.split(" ")[1]);
                    queue.put(number);
            }
        }
    }

    private static class MyQueue {
        private Node<Integer> head;
        private int size = 0;

        private boolean isEmpty() {
            return size == 0;
        }

        public void put(int x) {
            if (size == 0) {
                head = new Node<>(x, null);
            } else {
                Node nextNode = head;
                while (true) {
                    if (nextNode.next == null) {
                        break;
                    }
                    nextNode = nextNode.next;
                }
                Node newNode = new Node<>(x, null);
                nextNode.next = newNode;
            }
            size++;
        }

        public void get() {
            if (isEmpty()) {
                System.out.println("error");
            } else {
                System.out.println(head.value);
                head = head.next;
                size--;
            }
        }

        public void size() {
            System.out.println(size);
        }

        private static class Node<V> {
            public V value;
            public Node<V> next;

            public Node(V value, Node<V> next) {
                this.value = value;
                this.next = next;
            }
        }
    }
}
