package binarytree;


    class Node {
      String data;
      Node   left, right;

    Node(String data) {
        this.data = data;
        this.left=this.right=null;
    }
    public Node(int data){
        this.data=String.valueOf(data);
    }
}