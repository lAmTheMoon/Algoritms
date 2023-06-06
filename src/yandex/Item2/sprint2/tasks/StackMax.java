package yandex.Item2.sprint2.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class StackMax {

    private static int SIZE = 0;
    private static int MAX_NUM = Integer.MIN_VALUE;
    private static Node<Integer> head;
    private static Node<Integer>[] array = new Node[10000];

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            String[] commands = new String[n];
            for (int i = 0; i < n; i++) {
                commands[i] = reader.readLine();
            }

            printResult(n, commands);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printResult(int n, String[] commands) {
        for (int i = 0; i < n; i++) {
            String command = commands[i];
            switch (command) {
                case ("pop"):
                    pop();
                    break;
                case ("get_max"):
                    get_max();
                    break;
                default:
                    int number = Integer.parseInt(command.split(" ")[1]);
                    push(number);
            }
        }
    }

    public static void push(int number) {
        addElement(number);
        SIZE++;
        if (number > MAX_NUM) {
            MAX_NUM = number;
        }
    }

    public static void pop() {
        if (SIZE == 0) {
            System.out.println("error");
            return;
        }
        SIZE--;
        findMax(head.value);
        head = head.next;
    }

    public static void get_max() {
        if (SIZE == 0) {
            System.out.println("None");
            return;
        }
        System.out.println(MAX_NUM);
    }

    private static void addElement(int number) {
        Node<Integer> node = new Node<>(number, head);
        head = node;
        array[SIZE] = head;
    }
    private static void findMax(int max) {
        if (max != MAX_NUM) {
            return;
        }
        MAX_NUM = Integer.MIN_VALUE;
        Node<Integer> node = head.next;
        for (int i = 0; i < SIZE; i++) {
            if (node.value > MAX_NUM) {
                MAX_NUM = node.value;
            }
            node = node.next;
        }
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
