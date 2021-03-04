package linkedlist;

import org.junit.Test;

public class ReverseNodesinKGroups {
    public ListNode fullReverse(ListNode head,int k,int i,int iteration) {
        if (head == null || head.next == null || k==1 ) {
            if(iteration==0) {
                rootReversed = head;
            }
            nextNode=head.next;
            return head;
        }
        ;
        ListNode previous = fullReverse(head.next,--k,++i,iteration);
        previous.next = head;
        previous = previous.next;
        previous.next = null;
        if(i==1){
            previous.next=fullReverse(nextNode,k+1,0,++iteration);
        }
        return previous;
    }

    static ListNode rootReversed = null;
    static ListNode nextNode=null;

    public ListNode reverseKGroup(ListNode head, int k) {
        fullReverse(head,k,0,0);
        return rootReversed;
    }

    @Test
    public void reverseLinkedList() {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next = new ListNode(6);
        root.next.next.next.next.next.next = new ListNode(7);
        System.out.println(printLinkedList(reverseKGroup(root,2)));
    }
    String printLinkedList(ListNode root) {
        StringBuilder strBuilder = new StringBuilder();
        while (root != null) {
            strBuilder.append(root.val);
            root = root.next;
        }
        return strBuilder.toString();
    }
}
