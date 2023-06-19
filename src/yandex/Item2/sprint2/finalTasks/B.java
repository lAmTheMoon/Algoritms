package yandex.Item2.sprint2.finalTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

public class B {

    private static final Set<String> chars = Set.of("+", "-", "/", "*");

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] input = reader.readLine().split(" ");
            System.out.println(getResult(input));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int getResult(String[] input) {
        Queue<Integer> queue = new Queue<>();
        int result = 0;
        for (int i = 0; i < input.length; i++) {
            if (chars.contains(input[i])) {
            }
            switch (input[i]) {
                case "+":
                    break;
                case "-":
                    break;
                case "/":
                    break;
                case "*":
                    break;
                default:
                    throw new UnsupportedOperationException();
            }
            queue.add(Integer.parseInt(input[i]));
        }

        return result;
    }

    private void plus(Queue<Integer> queue) {

    }
}

class Queue<T> {

    private Node<T> head;

    public void add(T value) {
        Node<T> newNode = new Node<>(value, head);
        head.previous = newNode;
        head = newNode;
    }

    public int getHead() {

    }

    private static class Node<V> {
        private final V value;
        private Node<V> previous;

        public Node(V value, Node<V> previous) {
            this.value = value;
            this.previous = previous;
        }
    }
}

