package tree;

/**
 * Created by ruili1 on 9/24/17.
 *
 * Given a binary tree, check whether it is a mirror of itself
 * (ie, symmetric around its center).

 For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

     1
    / \
   2   2
  / \ / \
 3  4 4  3
 But the following [1,2,2,null,3,null,3] is not:
  1
 / \
 2   2
  \   \
  3    3

 */
public class LC101_SymmetricTree {

    public static boolean isMirror(TreeNode root) {

        if(root == null){
            return true;
        }

        return isMirror(root.left, root.right);
    }

    public static boolean isMirror(TreeNode t1, TreeNode t2){

        if(t1 == null && t2 == null){
            return true;
        }

        if(t1 == null && t2 != null){
            return false;
        }

        if(t1 != null && t2 == null){
            return false;
        }

        return t1.val == t2.val
                && isMirror(t1.left, t2.right)
                && isMirror(t1.right, t2.left);
    }

    public static void main(String[] args){

        BinaryTree tree = new BinaryTree();
        tree.root.setVal(1);
        tree.root.setLeft(2);
        tree.root.setRight(2);
        tree.root.left.setLeft(3);
        tree.root.left.setRight(4);
        tree.root.right.setLeft(4);
//        tree.root.right.setRight(3);

        tree.printBFT();

        System.out.println(isMirror(tree.root));
    }
}
