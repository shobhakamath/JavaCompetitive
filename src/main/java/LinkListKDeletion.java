public class LinkListKDeletion {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        ListNode fastptr = head;
        int i = 0, j = 0;
        int length = -1;
        while (current != null) {
            if (fastptr.next == null || fastptr==null) {
                length = j;
            } else {
                fastptr = fastptr.next.next;
                j += 2;
            }
            if (length != -1 && i == length - n) {
                current.next = current.next.next;
                break;
            }
            current = current.next;
            i++;




        }
        return head;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        ListNode elmt = removeNthFromEnd(root, 2);
        while (elmt != null) {
            System.out.print(elmt.val +" ");
            elmt = elmt.next;
        }
    }
}

class ListNode {
    int      val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}