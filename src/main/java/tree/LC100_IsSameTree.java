package tree;

/**
 * Created by ruili1 on 8/23/17.
 *
 * Given two binary trees, write a function to check if they are equal or not.

 Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

 */
public class LC100_IsSameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p == null && q == null) {
            return true;
        }

        if(p == null || q == null){
            return false;
        }

        return p.val == q.val
                && isSameTree(p.left, p.left)
                && isSameTree(q.right, q.right);
    }
}
