package tree;

/**
 * Created by ruili1 on 9/24/17.
 *
 * Given a binary tree, find the maximum path sum.

 For this problem, a path is defined as any sequence of nodes from some
 starting node to any node in the tree along the parent-child connections.
 The path must contain at least one node and does not need to go through the root.

 For example:
 Given the below binary tree,

   1
  / \
 2   3
 Return 6.
 */
public class LC124_MaxPathSum {

    static int max;

    public static int maxPathSum(TreeNode root) {

        max = Integer.MIN_VALUE;
        maxPathDown(root);
        return max;
    }

    public static int maxPathDown(TreeNode root){

        if(root == null){
            return 0;
        }

        int left = Math.max(0, maxPathDown(root.left));
        int right = Math.max(0, maxPathDown(root.right));

        max = Math.max(max, left + right + root.val);
        return Math.max(left, right) + root.val;
    }

    public static void main(String[] args){

        BinaryTree tree = new BinaryTree();
//        tree.root.setVal(2);
//        tree.root.setLeft(-1);
//        tree.root.setRight(3);

        tree.root.setVal(9);
        tree.root.setLeft(6);
        tree.root.setRight(-3);
        tree.root.right.setLeft(-6);
        tree.root.right.setRight(2);
        tree.root.right.right.setLeft(2);
        tree.root.right.right.left.setLeft(-6);
        tree.root.right.right.left.setRight(-6);
        tree.root.right.right.left.left.setLeft(-6);

        System.out.println(maxPathSum(tree.root));

    }
}
