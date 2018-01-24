package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ruili1 on 10/2/17.
 *
 * Given a binary tree, find its maximum depth.

 The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.


 */
public class LC104_GetMaxDepth {

    public static int maxDepth(TreeNode root) {

        if(root == null){
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static int maxDepthIterative(TreeNode node){

        if(node == null){
            return 0;
        }

        int depth = 0;
        Queue<TreeNode> currLayer = new LinkedList<TreeNode>();
        currLayer.add(node);
        while(!currLayer.isEmpty()){
            int size = currLayer.size();
            while(size-- > 0){
                TreeNode n = currLayer.poll();
                if(n.left != null){
                    currLayer.add(n.left);
                }
                if(n.right != null){
                    currLayer.add(n.right);
                }
            }
            depth++;
        }

        return depth;
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

        System.out.println(maxDepthIterative(tree.root));
    }

}
