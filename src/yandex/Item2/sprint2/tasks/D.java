package yandex.Item2.sprint2.tasks;


public class D {
    public static int solution(Node<String> head, String elem) {
        int index = 0;
        Node<String> node = head;
        while (true) {
            if (elem.equals(node.value)) {
                return index;
            }
            if (node.next == null) {
                return -1;
            }
            index++;
            node = node.next;
        }
    }

    private static void test() {
        Node<String> node3 = new Node<>("node3", null);
        Node<String> node2 = new Node<>("node2", node3);
        Node<String> node1 = new Node<>("node1", node2);
        Node<String> node0 = new Node<>("node0", node1);
        int idx = solution(node0, "node2");
        assert idx == 2;
    }

    public static void main(String[] args) {
        test();
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