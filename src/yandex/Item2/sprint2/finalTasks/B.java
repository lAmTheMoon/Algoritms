package yandex.Item2.sprint2.finalTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

/**
 * ID посылки 88372926
 *
 * Реализация на стеке, те каждый эл-т хранит ссылку на предыущий эл-т
 * Все методы работают за О(1)
 * Если подано число, то оно помещается на вершину стека, если это знак, то извлекаются два эл-та с вершины,
 * далее происходит калькуляция и результат помещается в вершину стека
 */
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
        int result;
        for (String obj : input) {
            if (chars.contains(obj)) {
                result = calculate(queue, obj);
                queue.push(result);
            } else {
                queue.push(Integer.parseInt(obj));
            }
        }
        return queue.pop();
    }

    private static int calculate(Queue<Integer> queue, String sign) {
        switch (sign) {
            case "+":
                return add(queue.pop(), queue.pop());
            case "-":
                return subtract(queue.pop(), queue.pop());
            case "/":
                return divide(queue.pop(), queue.pop());
            case "*":
                return multiply(queue.pop(), queue.pop());
            default:
                throw new UnsupportedOperationException();
        }
    }

    private static int add(int a, int b) {
        return a + b;
    }

    private static int subtract(int b, int a) {
        return a - b;
    }

    private static int multiply(int a, int b) {
        return a * b;
    }

    private static int divide(int b, int a) {
        return a < 0 && a % b != 0 ? a / b - 1 : a / b;
    }
}

class Queue<T> {

    private Node<T> head;

    public void push(T value) {
        head = new Node<>(value, head);
    }

    public T pop() {
        Node<T> node = head;
        head = node.previous;
        return node.value;
    }

    private static class Node<V> {
        private final V value;
        private final Node<V> previous;

        public Node(V value, Node<V> previous) {
            this.value = value;
            this.previous = previous;
        }
    }
}
