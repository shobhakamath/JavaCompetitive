package sorting;

public class MergeSort {

    private static Node mergeSort(Node A, int n) {
        if (n == 1) return A;
        int middle = (int) Math.floor(n / 2);

        Node A1 = new Node(A.data);
        Node root = A1;
        Node B = null;
        for (int i = 0; i < middle; i++) {

            if (i == middle - 1) {
                B = A.next;
                A1 = root;
            } else {
                A = A.next;
                A1.next = new Node(A.data);
                A1 = A1.next;
            }

        }

        return merge(mergeSort(A1, middle), mergeSort(B, n - middle));
    }

    private static Node merge(Node A, Node B) {
        if (A == null) return B;
        if (B == null) return A;
        if (A.data < B.data) {
            A.next = merge(A.next, B);
            return A;
        } else {
            B.next = merge(B.next, A);
            return B;
        }

    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.next = new Node(6);
        root.next.next = new Node(5);
        root.next.next.next = new Node(2);
        Node merged = mergeSort(root, 4);
        while (merged != null) {
            System.out.println(merged.data);
            merged = merged.next;
        }

    }
}

class Node {
    int  data;
    Node next;

    Node(int data) {
        this.data = data;
    }

}
