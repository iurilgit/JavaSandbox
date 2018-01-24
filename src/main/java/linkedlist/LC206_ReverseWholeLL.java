package linkedlist;

/**
 * Created by ruili1 on 8/19/17.
 *
 * Reverse a singly linked list.
 */
public class LC206_ReverseWholeLL {

    public static ListNode reverseList(ListNode head) {

        ListNode newHead = null;
        ListNode newHeadTemp = null;

        while(head != null){
            newHead = new ListNode(head.val);
            newHead.next = newHeadTemp;
            newHeadTemp = newHead;

            head = head.next;
        }

        return newHead;
    }

    public static ListNode reverseListRecursive(ListNode head){

        if (head == null){
            return null;
        }

        if(head.next == null){
            return head;
        }

        ListNode restReversed = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return restReversed;
    }

    public static void main(String[] args){

        ListNode l1 = new ListNode(2);
        ListNode p1 = l1;
        p1.next = new ListNode(4);
        p1 = p1.next;
        p1.next = new ListNode(3);

        ListNode.print(l1);
        ListNode l2 = reverseListRecursive(l1);
        ListNode.print(l2);

    }


}
