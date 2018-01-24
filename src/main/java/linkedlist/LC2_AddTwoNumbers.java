package linkedlist;

/**
 * Created by ruili1 on 8/19/17.
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8


 */


public class LC2_AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // define a link list for the sum
        ListNode l3 = new ListNode(0);

        // define pointers to the 3 linked lists
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode p3 = l3;

        // define sum and carry
        int sum = 0;
        int carry = 0; // store the carry (0/1) for each digit addition
        while(p1 != null || p2 != null){
            if(p1 != null){
                sum += p1.val;
            }
            if(p2 != null){
                sum += p2.val;
            }
            sum += carry;

            if(sum >= 10){
                carry = 1;
            }else{
                carry = 0;
            }

            p3.next = new ListNode(sum % 10);

            if(p1 != null) {
                p1 = p1.next;
            }
            if(p2 != null){
                p2 = p2.next;
            }
            p3 = p3.next;

            sum = 0;
        }

        if(carry > 0){
            p3.next = new ListNode(carry);
        }

        return l3.next;
    }

    public static void main(String[] args){

        ListNode l1 = new ListNode(2);
        ListNode p1 = l1;
        p1.next = new ListNode(4);
        p1 = p1.next;
        p1.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        ListNode p2 = l2;
        p2.next = new ListNode(6);
        p2 = p2.next;
        p2.next = new ListNode(9);
        p2 = p2.next;
        p2.next = new ListNode(2);

        ListNode.print(l1);
        ListNode.print(l2);
        ListNode l3 = addTwoNumbers(l1, l2);
        ListNode.print(l3);

    }



}
