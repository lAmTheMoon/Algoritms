package yandex.Item2.sprint2.tasks;

public class C {

    public static void main(String[] args) {
        test();
    }

    public static Node<String> solution(Node<String> head, int idx) {
        if (idx == 0) {
            return head.next;
        }

        Node<String> updatedNode = head;

        while (idx > 1) {
            idx--;
            updatedNode = updatedNode.next;
        }
        updatedNode.next = updatedNode.next == null ? null : updatedNode.next.next;
        return head;
    }

    private static void test() {
        Node<String> node3 = new Node<>("node3", null);
        Node<String> node2 = new Node<>("node2", node3);
        Node<String> node1 = new Node<>("node1", node2);
        Node<String> node0 = new Node<>("node0", node1);
        Node<String> newHead = solution(node0, 1);
        System.out.println(newHead.value);
        assert newHead == node0;
        assert newHead.next == node2;
        assert newHead.next.next == node3;
        assert newHead.next.next.next == null;
        // result is : node0 -> node2 -> node3
    }

    //Comment it before submitting
    private static class Node<V> {
        public V value;
        public Node<V> next;

        public Node(V value, Node<V> next) {
            this.value = value;
            this.next = next;
        }
    }
}