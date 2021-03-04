package linkedlist;

import static junit.framework.TestCase.assertTrue;

import org.junit.Test;

public class ReverseGivenPositions {



    public LinkedList fullReverse(LinkedList head) {
        if (head == null || head.next == null) {
            rootReversed = head;
            return head;
        }
        ;
        LinkedList previous = fullReverse(head.next);
        previous.next = head;
        previous = previous.next;
        previous.next = null;
        return previous;
    }

    static LinkedList rootReversed = null;

    public LinkedList reverseList(LinkedList head) {
        fullReverse(head);
        return rootReversed;
    }

    private LinkedList reverseWithPositions(LinkedList root, int start, int end) {
        LinkedList startPointer = null;
        LinkedList endpointer = null;
        LinkedList currentNode = root;
        int i = 0;
        while (currentNode != null) {
            i++;
            if (i + 1 == start) {
                startPointer = currentNode;
            }
            if (i == end) {
                endpointer = currentNode.next;
                break;
            }
            currentNode = currentNode.next;
        }

        startPointer = reverse(startPointer.next, end - start + 1, startPointer);
        startPointer.next = endpointer;
        return root;
    }

    private LinkedList reverse(LinkedList current, int i, LinkedList startPointer) {
        if (i == 0) return startPointer;
        startPointer = reverse(current.next, --i, startPointer);
        current.next = null;
        startPointer.next = current;
        return startPointer.next;
    }

    @Test
    public void reverseLinkedList() {
        LinkedList root = new LinkedList(1);
        root.next = new LinkedList(2);
        root.next.next = new LinkedList(3);
        root.next.next.next = new LinkedList(4);
        root.next.next.next.next = new LinkedList(5);
        root.next.next.next.next.next = new LinkedList(6);
        root.next.next.next.next.next.next = new LinkedList(7);
        System.out.println(printLinkedList(reverseList(root)));
    }

    @Test
    public void testReverseGivenPositions() {
        LinkedList root = new LinkedList(1);
        root.next = new LinkedList(2);
        root.next.next = new LinkedList(3);
        root.next.next.next = new LinkedList(4);
        root.next.next.next.next = new LinkedList(5);
        root.next.next.next.next.next = new LinkedList(6);
        root.next.next.next.next.next.next = new LinkedList(7);
        System.out.println(printLinkedList(root));
        LinkedList reversed = reverseWithPositions(root, 2, 5);
        String reversedString = printLinkedList(reversed);
        System.out.println(reversedString);
        assertTrue(reversedString.equals("1543267"));
    }

    String printLinkedList(LinkedList root) {
        StringBuilder strBuilder = new StringBuilder();
        while (root != null) {
            strBuilder.append(root.data);
            root = root.next;
        }
        return strBuilder.toString();
    }

}