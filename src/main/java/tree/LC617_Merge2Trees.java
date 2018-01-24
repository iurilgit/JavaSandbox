package tree;

/**
 * Created by ruili1 on 9/24/17.
 *
 * Given two binary trees and imagine that when you put one of them to cover the other,
 * some nodes of the two trees are overlapped while the others are not.

 You need to merge them into a new binary tree. The merge rule is that if two nodes overlap,
 then sum node values up as the new value of the merged node.
 Otherwise, the NOT null node will be used as the node of new tree.

 Example 1:
 Input:
 Tree 1                     Tree 2
     1                         2
    / \                       / \
   3   2                     1   3
  /                           \   \
 5                             4   7
 Output:
 Merged tree:
     3
    / \
   4   5
  / \   \
 5   4   7
 Note: The merging process must start from the root nodes of both trees.
 */
public class LC617_Merge2Trees {

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if (t1 == null && t2 == null) {
            return null;
        }

        if (t1 == null && t2 != null) {
            return t2;
        }

        if (t1 != null && t2 == null) {
            return t1;
        }

        TreeNode t = new TreeNode(t1.val + t2.val);
        t.left = mergeTrees(t1.left, t2.left);
        t.right = mergeTrees(t1.right, t2.right);

        return t;
    }

    public static void main(String[] args){

        BinaryTree t1 = new BinaryTree();
        t1.root.setVal(1);
        t1.root.setLeft(3);
        t1.root.setRight(2);
        t1.root.left.setLeft(5);
        t1.printBFT();

        BinaryTree t2 = new BinaryTree();
        t2.root.setVal(2);
        t2.root.setLeft(1);
        t2.root.setRight(3);
        t2.root.left.setRight(4);
        t2.root.right.setRight(7);
        t2.printBFT();

        TreeNode t3 = mergeTrees(t1.root, t2.root);

        BinaryTree tree = new BinaryTree(t3);
        tree.printBFT();
    }

}
