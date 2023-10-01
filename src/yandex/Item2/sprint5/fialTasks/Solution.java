package yandex.Item2.sprint5.fialTasks;

/**
 * ID посылки 90836213
 *
 * Чтобы удалить узел высотой h, нужно найти его положение в дереве, определить родителя и потомков,
 * тк при удалении узла нужно заменить его другим объектом.
 * Далее меняем ссылки у родителя и детей(если есть таковые)
 * Временная сложность в лучшем случае - O(h), а в худшем случае - O(n)
 * Пространственная сложность- O(h)
 */

// <template>
class Node {
    private int value;
    private Node left;
    private Node right;

    Node(Node left, Node right, int value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
// <template>

public class Solution {

    public static Node remove(Node root, int key) {
        if (root == null) {
            return null;
        }

        if (root.getValue() == key) {
            if (root.getRight() != null && root.getLeft() != null) {
                Node[] parentWithChildNodes = getParentWithChildMaxValueNodes(root.getRight(), root);
                Node parentNode = parentWithChildNodes[0];
                Node childNode = parentWithChildNodes[1];

                if (parentNode.getLeft() == childNode) {
                    parentNode.setLeft(childNode.getRight());
                } else {
                    parentNode.setRight(childNode.getRight());
                }
                childNode.setLeft(root.getLeft());
                childNode.setRight(root.getRight());
                return childNode;

            } else {
                if (root.getLeft() != null) {
                    return root.getLeft();
                } else {
                    return root.getRight();
                }
            }
        } else {
            if (root.getValue() > key) {
                if (root.getLeft() != null) {
                    root.setLeft(remove(root.getLeft(), key));
                }
            } else  {
                if (root.getRight() != null) {
                    root.setRight(remove(root.getRight(), key));
                }
            }
        }
        return root;
    }

    private static Node[] getParentWithChildMaxValueNodes(Node node, Node parentNode) {
        if (node.getLeft() != null) {
            return getParentWithChildMaxValueNodes(node.getLeft(), node);
        } else {
            return new Node[]{parentNode, node};
        }
    }

    private static void test() {
        Node node1 = new Node(null, null, 2);
        Node node2 = new Node(node1, null, 3);
        Node node3 = new Node(null, node2, 1);
        Node node4 = new Node(null, null, 6);
        Node node5 = new Node(node4, null, 8);
        Node node6 = new Node(node5, null, 10);
        Node node7 = new Node(node3, node6, 5);
        Node newHead = remove(node7, 10);
        System.out.println(newHead.getValue());
        assert newHead.getValue() == 5;
        assert newHead.getRight() == node5;
        assert newHead.getRight().getValue() == 8;
    }
}
