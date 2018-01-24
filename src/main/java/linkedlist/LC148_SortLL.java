package linkedlist;

/**
 * Created by ruili1 on 8/22/17.
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class LC148_SortLL {
    public static ListNode sortList(ListNode head) {

        // do nothing for empty list
        if(head == null || head.next == null){
            return head;
        }

        // separate the list into 2, pointed by head1 and head2
        ListNode head1 = head;  // pointing to first half of the list (do not change)
        ListNode head2 = head;  // pointing to second half of the list (will change later)

        // For each loop, head goes 2 step and p2 goes 1 step. So by the time head hits null, p2 points the center.
        int len = ListNode.size(head);
        ListNode p = ListNode.findNthNode(head, len/2 -1); // a temp pointer points one node before head2
        head2 = p.next;
        p.next = null;

//        System.out.print("first half:");
//        ListNode.print(head1);
//        System.out.print("first half:");
//        ListNode.print(head2);

        // sort p1 and p2
        ListNode p1 = sortList(head1);
        ListNode p2 = sortList(head2);

        // merge p1 and p2 into head (pointed by p)
        head = new ListNode(0);
        p = head;
        while(true){
            if(p1 == null){
                p.next = p2;
                break;
            }else if(p2 == null){
                p.next = p1;
                break;
            }else{
                if(p1.val < p2.val){
                    p.next = p1;
                    p1 = p1.next;
                }else{
                    p.next = p2;
                    p2 = p2.next;
                }
                p = p.next;
                p.next = null;
            }
        }
        return head.next;
    }

    public static int size(ListNode head){

        int i = 0;
        while(head != null) {
            i++;
            head = head.next;
        }

        return i;
    }

    public static ListNode findNthNode(ListNode head, int n){

        int i = 0;
        while(head != null){
            if(i == n){
                break;
            }
            i++;
            head = head.next;
        }

        return head;
    }

    public static void main(String[] args){

        ListNode l = new ListNode(5);
        ListNode p = l;
        p.next = new ListNode(4);
        p= p.next;
        p.next = new ListNode(3);
        p= p.next;
        p.next = new ListNode(7);
        p= p.next;
        p.next = new ListNode(1);

        System.out.print("org:");
        ListNode.print(l);
//        System.out.println(ListNode.size(l));
//        p = ListNode.findNthNode(l, 0);
//        ListNode.print(p);

        l = sortList(l);
        System.out.print("sorted:");
        ListNode.print(l);
    }
}
