package yandex.Item2.sprint5.tasks;

public class B {
    public static boolean treeSolution(Node head) {
        if (head == null) {
            return true;
        }
        int right_height = getHeight(head.right);
        int left_height = getHeight(head.left);
        boolean rightTreeIsCorrect = treeSolution(head.right);
        boolean leftTreeIsCorrect = treeSolution(head.left);
        return Math.abs(right_height - left_height) <= 1 && rightTreeIsCorrect && leftTreeIsCorrect;
    }

    public static int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }


    // <template>
    private static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    // <template>

    private static void test() {
        Node node1 = new Node(1);
        Node node2 = new Node(-5);
        Node node3 = new Node(3);
        node3.left = node1;
        node3.right = node2;
        Node node4 = new Node(10);
        Node node5 = new Node(2);
        node5.left = node3;
        node5.right = node4;
        assert treeSolution(node5);
        System.out.println(treeSolution(node5));
    }

    public static void main(String[] args) {
        test();
    }
}