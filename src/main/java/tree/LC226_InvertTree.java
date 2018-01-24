package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ruili1 on 10/3/17.
 *
 * Invert a binary tree.

      4
    /   \
   2     7
  / \   / \
 1   3 6   9
 to
      4
    /   \
   7     2
  / \   / \
 9   6 3   1

 --
 Idea:
 1. Recursive
 2. DFT using a stack. But at each node, swap its children
 */
public class LC226_InvertTree {

    public static TreeNode invertTreeRecursive(TreeNode node) {

        if(node == null){
            return node;
        }

        TreeNode temp;
        temp = node.left;
        node.left = invertTreeRecursive(node.right);
        node.right = invertTreeRecursive(temp);

        return node;
    }

    public static TreeNode invertTreeIterative(TreeNode root) {

        if (root == null) {
            return null;
        }

        final Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if(node.left != null) {
                queue.offer(node.left);
            }
            if(node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args){


        BinaryTree tree = new BinaryTree();

        // complex tree
        tree.root.setVal(1);
        tree.root.setLeft(2);
        tree.root.setRight(3);
        tree.root.left.setLeft(4);
        tree.root.left.setRight(5);
        tree.root.right.setLeft(6);
        tree.root.left.left.setRight(7);

        tree.printBFT();
        tree.printDFTPreOrder();

        TreeNode root2 = invertTreeRecursive(tree.root);

        BinaryTree tree2 = new BinaryTree(root2);
        tree2.printBFT();
        tree2.printDFTPreOrder();
    }
}
