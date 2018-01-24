package tree;

/**
 * Created by ruili1 on 9/24/17.
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

 According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined
 between two nodes v and w as the lowest node in T that has both v and w as descendants
 (where we allow a node to be a descendant of itself).”

         _______3______
        /              \
     ___5__          ___1__
    /      \        /      \
   6      _2       0       8
  /  \
 7   4
 For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3.
 Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself
 according to the LCA definition.
 */
public class LC236_LowestCommonAncestor {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null || p == null || q == null){
            return null;
        }

        if(root == p || root == q){
            return root;
        }

        if((contains(root.left, p) && contains(root.right, q))
        || (contains(root.left, q) && contains(root.right, p))){
            return root;
        }

        if(contains(root.left, p)){
            return lowestCommonAncestor(root.left, p, q);
        }else{
            return lowestCommonAncestor(root.right, p, q);
        }
    }

    public static boolean contains(TreeNode root, TreeNode n){

        if(root == null){
            return false;
        }

        if(root == n){
            return true;
        }else{
            return contains(root.left, n) || contains(root.right, n);
        }
    }

    public static void main(String[] args){

        BinaryTree tree = new BinaryTree();
//        tree.root.setVal(3);
//        tree.root.setLeft(5);
//        tree.root.setRight(1);
//        tree.root.left.setLeft(6);
//        tree.root.left.setRight(2);
//        tree.root.left.right.setLeft(7);
//        tree.root.left.right.setRight(4);
//        tree.root.right.setLeft(0);
//        tree.root.right.setRight(8);

        tree.root.setVal(1);
        tree.root.setLeft(3);
        tree.root.setRight(2);

        tree.printBFT();

        TreeNode p = tree.root.left;    // 5
        TreeNode q = tree.root.right;   // 1
        System.out.println(lowestCommonAncestor(tree.root, p, q).val);

//        p = tree.root.left;             // 5
//        q = tree.root.left.right.right; // 4
//        System.out.println(lowestCommonAncestor(tree.root, p, q).val);
    }
}
