package linkedlist;

/**
 * Created by ruili1 on 8/19/17.
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static void print(ListNode list){

        String s = "";

        ListNode p = list;
        while(p != null){
            s = s + p.val + " -> ";
            p = p.next;
        }

        System.out.println(s);
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

        ListNode l1 = new ListNode(2);
        ListNode p1 = l1;
        p1.next = new ListNode(4);
        p1 = p1.next;
        p1.next = new ListNode(3);

        print(l1);
    }
}