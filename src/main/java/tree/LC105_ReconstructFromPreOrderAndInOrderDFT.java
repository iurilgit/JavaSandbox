package tree;

import java.util.List;

/**
 * Created by ruili1 on 9/29/17.
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.

 Note:
 You may assume that duplicates do not exist in the tree.
 */
public class LC105_ReconstructFromPreOrderAndInOrderDFT {

    public static TreeNode reconstructTreeFromDFT(List<Integer> valsInOrder, List<Integer> valsPreOrder){

        if(valsInOrder.isEmpty() && valsPreOrder.isEmpty()){
            return null;
        }

        Integer rootVal = valsPreOrder.get(0);
        int rootValIdxWithinInOrder = valsInOrder.indexOf(rootVal);

        List<Integer> valsInOrderLeft = valsInOrder.subList(0, rootValIdxWithinInOrder);
        List<Integer> valsInOrderRight = valsInOrder.subList(rootValIdxWithinInOrder + 1, valsInOrder.size());
        System.out.println(valsInOrderLeft);
        System.out.println(valsInOrderRight);

        List<Integer> valsPreOrderLeft = valsPreOrder.subList(1, valsInOrderLeft.size() + 1);
        List<Integer> valsPreOrderRight = valsPreOrder.subList(valsInOrderLeft.size() + 1, valsPreOrder.size());
        System.out.println(valsPreOrderLeft);
        System.out.println(valsPreOrderRight);

        TreeNode currRoot = new TreeNode(rootVal);
        currRoot.left  = reconstructTreeFromDFT(valsInOrderLeft, valsPreOrderLeft);
        currRoot.right = reconstructTreeFromDFT(valsInOrderRight, valsPreOrderRight);

        return currRoot;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private static TreeNode buildTree(int[] preorder, int preorderStartIdx, int preorderEndIdx,
                               int[] inorder, int inorderStartIdx, int inorderEndIdx){
        if(preorderEndIdx == preorderStartIdx || inorderEndIdx == inorderStartIdx){
            return null;
        }

        int rootVal = preorder[preorderStartIdx];
        int rootValIdxInInOrder = findValIdxInArray(inorder, inorderStartIdx, inorderEndIdx, rootVal);
        int leftTreeSize = rootValIdxInInOrder - inorderStartIdx;
        int rightTreeSize = inorderEndIdx - rootValIdxInInOrder;

        int preorderLeftStartIdx = preorderStartIdx + 1;
        int preorderLeftEndIDx = preorderStartIdx + leftTreeSize + 1;
        int preorderRightStartIdx = preorderLeftEndIDx;
        int preorderRightEndIdx = preorderEndIdx;

        int inorderLeftStartIdx = inorderStartIdx;
        int inorderLeftEndIdx = inorderStartIdx + leftTreeSize;
        int inorderRightStartIdx = rootValIdxInInOrder + 1;
        int inorderRightEndIdx = inorderEndIdx;

        TreeNode leftTree = buildTree(preorder, preorderLeftStartIdx, preorderLeftEndIDx,
                inorder, inorderLeftStartIdx, inorderLeftEndIdx);
        TreeNode rightTree = buildTree(preorder, preorderRightStartIdx, preorderRightEndIdx,
                inorder, inorderRightStartIdx, inorderRightEndIdx);
        TreeNode root = new TreeNode(rootVal);
        root.left = leftTree;
        root.right = rightTree;

        return root;
    }

    private static int findValIdxInArray(int[] array, int startIdx, int endIdx, int val){

        for(int i = startIdx; i < endIdx; i++){
            if(array[i] == val){
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args){

        int[] preorder = {1, 2, 4, 3, 5};
        int[] inorder = {2, 4, 1, 5, 3};

        BinaryTree tree = new BinaryTree(buildTree(preorder, inorder));
        tree.printDFTPreOrder();
        tree.printDFTInOrder();
    }
}
