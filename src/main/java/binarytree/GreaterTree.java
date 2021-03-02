package binarytree;

public class GreaterTree {

    private static void postOrderTraversal(TreeNode node) {
        if (node == null) return;
        postOrderTraversal(node.right);
        System.out.print (node.data + " ");
        postOrderTraversal(node.left);
    }

    private static void inOrderTraversal(TreeNode node) {
        if (node == null) return;
        System.out.print (node.data + " ");
        postOrderTraversal(node.left);

        postOrderTraversal(node.right);
    }
    static TreeNode sortedArrayToBST(Integer arr[], int start, int end) {

        /* Base Case */
        if (start > end) {
            return null;
        }

        /* Get the middle element and make it root */
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(arr[mid]);

        /* Recursively construct the left subtree and make it
         left child of root */
        node.left = sortedArrayToBST(arr, start, mid - 1);

        /* Recursively construct the right subtree and make it
         right child of root */
        node.right = sortedArrayToBST(arr, mid + 1, end);

        return node;
    }
    public static TreeNode insertLevelOrder(Integer[] arr, TreeNode root,
        int i)
    {
        // Base case for recursion
        if (i < arr.length) {
            TreeNode temp = new TreeNode(arr[i]);
            root = temp;

            // insert left child
            root.left = insertLevelOrder(arr, root.left,
                2 * i + 1);

            // insert right child
            root.right = insertLevelOrder(arr, root.right,
                2 * i + 2);
        }
        return root;
    }

    static int sum=0;
    static void transformTreeUtil(TreeNode root)
    {

        // Base case
        if (root == null || root.data==null)
            return;

        // Recur for right subtree
        transformTreeUtil(root.right);

        // Update sum
        sum = sum + root.data;

        // Store old sum in current node
        root.data = sum - root.data;

        // Recur for left subtree
        transformTreeUtil(root.left);
    }
    public static void main(String[] args) {
        Integer[] bTree = new Integer[] { 4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8 };
        TreeNode root = insertLevelOrder(bTree, new TreeNode(), 0);
        postOrderTraversal(root);
        System.out.println("\n");
        transformTreeUtil(root);
        inOrderTraversal(root);    }

}

class TreeNode {
    Integer      data;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(Integer val) {
        this.data = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.data = val;
        this.left = left;
        this.right = right;
    }
}
