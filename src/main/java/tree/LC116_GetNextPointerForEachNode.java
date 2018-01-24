package tree;

import com.sun.java.swing.plaf.motif.MotifTreeCellRenderer;

/**
 * Created by ruili1 on 9/24/17.
 *
 * Given a binary tree

 struct TreeLinkNode {
 TreeLinkNode *left;
 TreeLinkNode *right;
 TreeLinkNode *next;
 }

 Populate each next pointer to point to its next right node.
 If there is no next right node, the next pointer should be set to NULL.

 Initially, all next pointers are set to NULL.

 Note:

 You may only use constant extra space.
 You may assume that it is a perfect binary tree
 (ie, all leaves are at the same level, and every parent has two children).
 For example,
 Given the following perfect binary tree,
     1
    /  \
   2    3
  / \  / \
 4  5  6  7
 After calling your function, the tree should look like:
     1 -> NULL
    /  \
   2 -> 3 -> NULL
  / \  / \
 4->5->6->7 -> NULL

 */
public class LC116_GetNextPointerForEachNode {

    class TreeLinkNode extends TreeNode{

        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        public TreeLinkNode(int x){
            super(x);
            next = null;
        }
    }

    public static void connect(TreeLinkNode root) {

        TreeLinkNode curr = root;
        TreeLinkNode leftMostNode = root.left;

        while(curr.left != null){
            leftMostNode = curr.left;
            while(curr != null) {
                curr.left.next = curr.right;
                curr.right.next = curr.next != null? curr.next.left : null;
                curr = curr.next;
            }
            curr = leftMostNode;
        }
    }

    public static void main(String[] args){


    }
}
