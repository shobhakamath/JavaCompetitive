package binarytree;

import org.junit.jupiter.api.Test;

public class BoundaryTraversal {
    static boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    void printLeftTraversal(Node node) {
        if (node.left == null) return;
        System.out.print(" " + node.data);
        printLeftTraversal(node.left);
    }

    void printInternalNodes(Node node) {
        if (node == null) return;
        if (isLeaf(node)) {
            System.out.print(" " + node.data);
            return;
        }
        printInternalNodes(node.left);
        printInternalNodes(node.right);
    }

    public void boundaryTraversal(Node node) {
        printLeftTraversal(node);
        printInternalNodes(node);
        printRightTraversal(node);
    }

    private void printRightTraversal(Node node) {
        if (node.right != null) {
            printRightTraversal(node.right);
        }
        System.out.print(" " + node.data);
    }

    @Test
    public void boundaryTraversal() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(10);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.left.right.left = new Node(12);
        root.left.left.right.right = new Node(13);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(11);
        root.right.right.right = new Node(12);
        root.right.right.right.right = new Node(15);
        root.right.right.left.left = new Node(14);
        boundaryTraversal(root);
    }
}
