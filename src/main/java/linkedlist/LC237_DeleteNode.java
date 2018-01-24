package linkedlist;

/**
 * Created by ruili1 on 10/2/17.
 *
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

 Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3,
 the linked list should become 1 -> 2 -> 4 after calling your function.


 */
public class LC237_DeleteNode {

    public static void deleteNode(ListNode node) {

        ListNode next = node.next;

        while(node.next != null){
            node.val = next.val;
            node.next = next.next;

            node = node.next;
            next = next.next;
        }
    }

    public static void main(String[] args){

        ListNode l1 = new ListNode(1);
        ListNode p1 = l1;
        p1.next = new ListNode(2);
        p1 = p1.next;
        p1.next = new ListNode(3);
        p1 = p1.next;
        p1.next = new ListNode(4);
        p1 = p1.next;
        p1.next = new ListNode(5);

        ListNode.print(l1);

        ListNode node = l1.next.next;
        System.out.println(node.val);
        deleteNode(node);

        ListNode.print(l1);

    }
}
