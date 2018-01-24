package tree;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import java.util.Arrays;

/**
 * Created by ruili1 on 9/24/17.
 *
 * Given an array where elements are sorted in ascending order,
 * convert it to a height balanced BST.


 */
public class LC108_CovertSortedArrayToBST {

    public static TreeNode sortedArrayToBST(int[] nums) {

        if(nums.length == 0){
            return null;
        }

        int mid = nums.length/2;
        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums, mid + 1, nums.length);

        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(left);
        node.right = sortedArrayToBST(right);
        return node;
    }

    public static void main(String[] args){

        int[] nums = {1, 2, 3, 4, 5, 6};
        TreeNode root = sortedArrayToBST(nums);
        BinaryTree tree = new BinaryTree(root);
        tree.printBFT();
    }
}
