package linkedlist;

/**
 * Created by ruili1 on 8/19/17.
 *
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.

 For example:
 Given 1->2->3->4->5->NULL, m = 2 and n = 4,

 return 1->4->3->2->5->NULL.

 Note:
 Given m, n satisfy the following condition:
 1 ≤ m ≤ n ≤ length of list.
 */
public class LC92_ReverseSubLL {

    public static ListNode reverseBetween(ListNode head, int m, int n) {

        // back up head
        ListNode headBak = head;

        // get two pointers to point to the mth and nth elements
        ListNode[] pointers = new ListNode[n-m+1];
        int i = 0;
        while (head != null){
            i++;

            if(i >= m){
                pointers[i-m] = head;
            }

            if (i == n){
                break;
            }

            head = head.next;
        }

        // between mth and nth element, swap start/end and move pointer towards center
        int len = pointers.length;
        for(int j = 0; j < len/2; j++){
            int temp = pointers[j].val;
            pointers[j].val = pointers[len-1-j].val;
            pointers[len-1-j].val = temp;
        }

        return headBak;
    }

    public static void main(String[] args){

        ListNode l1 = new ListNode(2);
        ListNode p1 = l1;
        p1.next = new ListNode(4);
        p1 = p1.next;
        p1.next = new ListNode(3);
        p1 = p1.next;
        p1.next = new ListNode(5);

        ListNode.print(l1);
        ListNode l2 = reverseBetween(l1, 1, 4);
        ListNode.print(l2);

    }

}
