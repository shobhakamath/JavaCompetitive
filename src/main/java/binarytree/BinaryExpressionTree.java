package binarytree;

public class BinaryExpressionTree {

    public static void main(String[] args) {
        Node root = new Node("+");
        root.left = new Node("*");
        root.right = new Node("/");
        root.left.left = new Node("-");
        root.left.right = new Node("5");
        root.right.left = new Node("21");
        root.right.right = new Node("7");
        root.left.left.left = new Node("10");
        root.left.left.right = new Node("5");

        System.out.println("The value of the expression tree is " + evaluate(root));
    }

    private static int processNode(int left, int right, String op) {
        if (op.equals("*")) return left * right;
        if (op.equals("-")) return left - right;
        if (op.equals("+")) return left + right;
        if (op.equals("/")) return left / right;
        return 0;
    }

    private static int evaluate(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return Integer.valueOf(root.data);
        }
        int left = evaluate(root.left);
        int right = evaluate(root.right);
        return processNode(left, right, root.data);
    }
}


