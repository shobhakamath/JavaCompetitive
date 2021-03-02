package binarytree;

import java.util.Stack;
import org.junit.jupiter.api.Test;

public class InorderSpiralTraversal {

    private Stack<Node> getLtoRStack(Stack<Node> stackRtoL){
        Stack<Node> stack=new Stack<Node>();
        Node node=null;
        while(!stackRtoL.empty()){
            node=stackRtoL.pop();
            if (node.left != null) {
                stack.push(node.left);
                System.out.println(node.left.data);
            }
            if (node.right != null) {
                stack.push(node.right);
                System.out.println(node.right.data);
            }
        }
        return stack;
    }
    private void spiralTraversal(Node node){
        Stack<Node> stackRtoL=new Stack<Node>();
        stackRtoL.push(node);
        System.out.println(node.data);
        while(!stackRtoL.empty()){
            Stack<Node> stackLtoR = getLtoRStack(stackRtoL);
            stackRtoL = getRtoLStack(stackLtoR);
        }
     }

    private Stack<Node> getRtoLStack(Stack<Node> stackLtoR) {
        Stack<Node> stack=new Stack<Node>();
        Node node=null;
        while(!stackLtoR.empty()){
            node=stackLtoR.pop();
            if(node.right!=null){
                stack.push(node.right);
                System.out.println(node.right.data);
            }
            if(node.left!=null){
                stack.push(node.left);
                System.out.println(node.left.data);
            }
        }
       return stack;
    }

    @Test
    public void boundaryTraversal() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(4);

        root.left.right.left = new Node(8);
        root.left.right.right = new Node(9);
        root.left.right.right.left = new Node(11);
        root.left.right.right.right = new Node(10);
        spiralTraversal(root);


    }
}
