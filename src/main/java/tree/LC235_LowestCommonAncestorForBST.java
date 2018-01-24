package tree;

/**
 * Created by ruili1 on 9/24/17.
 *
 * Given a binary searchRange tree (BST), find the lowest common ancestor (LCA)
 * of two given nodes in the BST.

 According to the definition of LCA on Wikipedia: “The lowest common ancestor
 is defined between two nodes v and w as the lowest node in T that has both v and w
 as descendants (where we allow a node to be a descendant of itself).”

         _______6______
        /              \
     ___2__          ___8__
    /      \        /      \
   0      _4       7       9
  /  \
 3   5
 For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6.
 Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself
 according to the LCA definition.
 */
public class LC235_LowestCommonAncestorForBST {

    // recursive version
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }

        if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }

    // iterative version
    public static TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {

        while((root.val - p.val)*(root.val - q.val) > 0){
            root = root.val > p.val? root.left : root.right;
        }
        return root;
    }


    public static void main(String[] args){

        BinaryTree tree = new BinaryTree();
        tree.root.setVal(6);
        tree.root.setLeft(2);
        tree.root.setRight(8);
        tree.root.left.setLeft(0);
        tree.root.left.setRight(4);
        tree.root.left.right.setLeft(3);
        tree.root.left.right.setRight(5);
        tree.root.right.setLeft(7);
        tree.root.right.setRight(9);
        tree.printBFT();

        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(8);
        System.out.println(lowestCommonAncestorIterative(tree.root, p, q).val);

        p = new TreeNode(2);
        q = new TreeNode(4);
        System.out.println(lowestCommonAncestorIterative(tree.root, p, q).val);
    }
}
