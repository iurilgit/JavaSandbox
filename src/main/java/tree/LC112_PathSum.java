package tree;

/**
 * Created by ruili1 on 9/29/17.
 *
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that
 * adding up all the values along the path equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
       5
      / \
     4   8
    /   / \
   11  13  4
  /  \      \
 7    2      1
 return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class LC112_PathSum {

    public static boolean hasPathSum(TreeNode root, int sum) {

        if(root == null){
            return false;
        }

        if(root.left == null && root.right == null){
            return root.val == sum;
        }

        return hasPathSum(root.left, sum - root.val)
            || hasPathSum(root.right, sum - root.val);

    }

    public static void main(String[] args){

        BinaryTree tree = new BinaryTree();
        tree.root.setVal(5);
        tree.root.setLeft(4);
        tree.root.setRight(8);
        tree.root.left.setLeft(11);
        tree.root.left.left.setLeft(7);
        tree.root.left.left.setRight(2);
        tree.root.right.setLeft(13);
        tree.root.right.setRight(4);
        tree.root.right.right.setRight(1);

        System.out.println(hasPathSum(tree.root, 23));

    }
}
