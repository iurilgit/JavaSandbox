package tree;

/**
 * Created by ruili1 on 9/24/17.
 *
 * Given a binary tree, determine if it is height-balanced.

 For this problem, a height-balanced binary tree is defined as a binary tree
 in which the depth of the two subtrees of every node never differ by more than 1.

 */
public class LC110_BalancedTree {

    public static boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }

        return (Math.abs(height(root.left) - height(root.right)) <= 1)
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    public static int height(TreeNode root){

        if(root == null){
            return 0;
        }else{
            int leftTreeHeight = height(root.left);
            int rightTreeHeight = height(root.right);
            return Math.max(leftTreeHeight, rightTreeHeight) + 1;
        }
    }

    public static void main(String[] args){

        BinaryTree tree = new BinaryTree();
        tree.root.setVal(1);
        tree.root.setLeft(2);
        tree.root.setRight(3);
        tree.root.left.setLeft(4);
        tree.root.left.setRight(5);
        tree.root.left.left.setLeft(6);

//        tree.root.setVal(1);
//        tree.root.setLeft(2);
//        tree.root.left.setLeft(3);
//        tree.root.left.left.setLeft(4);
//        tree.root.setRight(2);
//        tree.root.right.setRight(3);
//        tree.root.right.right.setRight(4);

        System.out.println(isBalanced(tree.root));
    }
}
