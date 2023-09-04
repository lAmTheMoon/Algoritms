package yandex.Item2.sprint5.tasks;

public class E {

    private static int MAIN = Integer.MIN_VALUE;
    private static boolean isNotFirstCheck = false;

    public static boolean treeSolution(Node head) {
        boolean isBst = true;
        if (MAIN == Integer.MIN_VALUE) {
            MAIN = head.value;
        }
        if (head != null) {
            boolean left = isNotMainNode(head) && treeSolution(head.left);
            isNotFirstCheck = false;
            boolean right = isNotMainNode(head) && treeSolution(head.right);

            isBst = left && right;
        }
        return isBst;
    }

    private static boolean isNotMainNode(Node node) {
        int value = node.value;
        if (isNotFirstCheck) {
            if (value < MAIN) {
                return (node.left == null || node.left.value < MAIN && node.left.value < value) &&
                        (node.right == null || node.right.value < MAIN && node.right.value > value);
            } else {
                return (node.right == null || node.right.value > MAIN && node.right.value > value) &&
                        (node.left == null || node.left.value > MAIN && node.left.value < value);
            }
        } else {
            isNotFirstCheck = true;
            return (node.left == null || node.left.value < value) && (node.right == null || node.right.value > value);
        }
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

        Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    // <template>

    public static void main(String[] args) {
        test();
    }


    private static void test() {
        Node node1 = new Node(1, null, null);
        Node node2 = new Node(4, null, null);
        Node node3 = new Node(3, node1, node2);
        Node node4 = new Node(8, null, null);
        Node node5 = new Node(5, node3, node4);
        assert treeSolution(node5);
        node2.value = 5;
        assert !treeSolution(node5);
    }
}
