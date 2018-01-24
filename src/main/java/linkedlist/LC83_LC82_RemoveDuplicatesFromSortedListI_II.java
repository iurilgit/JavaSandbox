package linkedlist;

import java.util.List;

/**
 * Created by ruili1 on 12/18/17.
 *
 *
 I: LC83:
 Given a sorted linked list, delete all duplicates such that each element appear only once.

 For example,
 Given 1->1->2, return 1->2.
 Given 1->1->2->3->3, return 1->2->3.

 II: LC82:
 Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

 For example,
 Given 1->2->3->3->4->4->5, return 1->2->5.
 Given 1->1->1->2->3, return 2->3.

 --------
 solution:
 I: Same as LC26 (array) except this is linked list
 II: a bit different with an additional variable to keep track of whether a number is a duplicate

 */
public class LC83_LC82_RemoveDuplicatesFromSortedListI_II {

    // I:
    public static ListNode deleteDuplicates(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }

        ListNode head2 = head;

        ListNode p = head;
        ListNode p2 = head2;
        p = p.next;
        while(p != null){
            if(p.val != p2.val){
                p2 = p2.next;
                p2.val = p.val;
            }
            p = p.next;
        }

        p2.next = null;
        return head2;
    }

    // II:
    public static ListNode deleteDuplicatesII(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }

        int duplicateCount = 1;

        ListNode p2Prev = new ListNode(0);
        p2Prev.next = head;
        ListNode p2 = head;
        ListNode head2 = p2Prev;

        ListNode p = head;
        while(p != null){
            if(p.next != null && p.val == p.next.val){
                duplicateCount++;
            }else{
                if(duplicateCount == 1){
                    p2.val = p.val;
                    p2 = p2.next;
                    p2Prev = p2Prev.next;
                }else {
                    duplicateCount = 1;
                }
            }
            p = p.next;
        }

        p2Prev.next = null;
        return head2.next;
    }


    public static ListNode deleteDuplicatesRecursive(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }

        head.next = deleteDuplicatesRecursive(head.next);
        return head.val == head.next.val? head.next : head;
    }

    public static void main(String[] args){

        ListNode l = new ListNode(1);
        ListNode p = l;
        p.next = new ListNode(2);
        p= p.next;
        p.next = new ListNode(2);
        p= p.next;
        p.next = new ListNode(2);
        p= p.next;
        p.next = new ListNode(2);
        p= p.next;
        p.next = new ListNode(4);
        p= p.next;
        p.next = new ListNode(4);

        System.out.println("before:");
        ListNode.print(l);

//        ListNode l1 = deleteDuplicates(l);
//        System.out.println("dedupped I:");
//        ListNode.print(l1);

        ListNode l2 = deleteDuplicatesII(l);
        System.out.println("dedupped II:");
        ListNode.print(l2);
    }


}
