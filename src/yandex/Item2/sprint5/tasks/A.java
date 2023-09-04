package yandex.Item2.sprint5.tasks;

public class A {
    public static int treeSolution(Node head) {
        if (head == null) {
            return Integer.MIN_VALUE;
        }
        int max = head.value;

        int left = treeSolution(head.left);
        int right = treeSolution(head.right);

        return Math.max(max, Math.max(left, right));
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

    public static void main(String[] args) {
        test();
    }

    private static void test() {
        Node node1 = new Node(1);
        Node node2 = new Node(-5);
        Node node3 = new Node(3);
        node3.left = node1;
        node3.right = node2;
        Node node4 = new Node(2);
        node4.left = node3;
        assert treeSolution(node4) == 3;
    }
}
