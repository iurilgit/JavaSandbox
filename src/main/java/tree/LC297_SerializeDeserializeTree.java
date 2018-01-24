package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ruili1 on 9/27/17.
 *
 * Serialization is the process of converting a data structure or object into a sequence of bits
 * so that it can be stored in a file or memory buffer, or transmitted across a network connection link
 * to be reconstructed later in the same or another computer environment.

 Design an algorithm to serialize and deserialize a binary tree. There is no restriction on
 how your serialization/deserialization algorithm should work. You just need to ensure that
 a binary tree can be serialized to a string and this string can be deserialized to the
 original tree structure.

 For example, you may serialize the following tree

     1
    / \
   2   3
  / \
 4   5
 as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree.
 You do not necessarily need to follow this format, so please be creative and come up with
 different approaches yourself.

 Note: Do not use class member/global/static variables to store states.
 Your serialize and deserialize algorithms should be stateless.

 */
public class LC297_SerializeDeserializeTree {

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {

        List<TreeNode> currLayer = new ArrayList<TreeNode>();
        List<TreeNode> nextLayer = new ArrayList<TreeNode>();

        currLayer.add(root);

        List<String> serialized = new ArrayList<String>();
        while(!currLayer.isEmpty()) {
            for (TreeNode node : currLayer) {
                if (node != null) {
                    serialized.add(String.valueOf(node.val));
                    nextLayer.add(node.left);
                    nextLayer.add(node.right);
                } else {
                    serialized.add("null");
                }
            }
            currLayer = new ArrayList<TreeNode>(nextLayer);
            nextLayer.clear();
        }

        int lastNonNullValIdx = serialized.size() -1;
        for(int i = serialized.size() - 1; i >= 0; i--){
            if(!serialized.get(i).equals("null")){
                lastNonNullValIdx = i;
                break;
            }
        }
        return serialized.subList(0, lastNonNullValIdx + 1).toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {

        data = data.trim();
        data = data.substring(1, data.length() -1);
        String[] vals = data.split(",");

        if(vals.length == 0){
            return null;
        }

//        int idx = 0; // mega index for vals
        int idxInNextLayer = 1;
        List<TreeNode> nodesInCurrLayer = new ArrayList<TreeNode>();
        List<TreeNode> nodesInNextLayer = new ArrayList<TreeNode>();
        TreeNode root = constructNode(vals[0]);
        nodesInCurrLayer.add(root);
        while(idxInNextLayer < vals.length){
            for(TreeNode currNode : nodesInCurrLayer) {
                if(currNode != null){
                    if(idxInNextLayer < vals.length) {
                        String leftVal = vals[idxInNextLayer++];
                        currNode.left = constructNode(leftVal);
                        nodesInNextLayer.add(currNode.left);
                    }else{
                        break;
                    }

                    if(idxInNextLayer < vals.length) {
                        String rightVal = vals[idxInNextLayer++];
                        currNode.right = constructNode(rightVal);
                        nodesInNextLayer.add(currNode.right);
                    }else{
                        break;
                    }
                }
            }
//            idxInNextLayer += nodesInCurrLayer.size();
            nodesInCurrLayer = new ArrayList<TreeNode>(nodesInNextLayer);
            nodesInNextLayer.clear();
        }

        return root;
    }

    private static TreeNode constructNode(String s){

        s = s.trim();
        if(s.equals("null")){
            return null;
        }else{
            return new TreeNode(Integer.parseInt(s));
        }
    }

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
//        tree.root.setVal(1);
//        tree.root.setRight(2);
//        tree.root.right.setLeft(3);

//        tree.root.setVal(1);
//        tree.root.setLeft(2);
//        tree.root.setRight(3);
//        tree.root.right.setLeft(4);
//        tree.root.right.setRight(5);

        tree.root.setVal(5);
        tree.root.setLeft(4);
        tree.root.setRight(7);
        tree.root.left.setLeft(3);
        tree.root.left.left.setLeft(-1);
        tree.root.right.setLeft(2);
        tree.root.right.left.setLeft(9);

        String s = serialize(tree.root);
        System.out.println(s);
        TreeNode root = deserialize(s);
        BinaryTree tree2 = new BinaryTree(root);
        tree2.printBFT();
        tree2.printDFTInOrder();
    }
}
