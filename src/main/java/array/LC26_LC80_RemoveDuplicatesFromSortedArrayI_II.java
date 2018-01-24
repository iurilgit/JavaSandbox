package array;

import java.util.Arrays;

/**
 * Created by ruili1 on 12/1/17.
 *
 I: LC26

 Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.

 Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

 Example:

 Given nums = [1,1,2],

 Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 It doesn't matter what you leave beyond the new length.

 II: LC80
 Follow up for "Remove Duplicates":
 What if duplicates are allowed at most twice?

 For example,
 Given sorted array nums = [1,1,1,2,2,3],

 Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3.
 It doesn't matter what you leave beyond the new length.

 -------
 Solution:
 I:
 2 pointers:
 1 loops through the array (i) and the other points to the next none duplicated element (j)
 When nums[i] != nums[j], assign the one pointed by j to the value pointed by i.
 j moves slower than i and always points to the last element of the new array.

 II:
 Similar to I, but need a variable to keep track of duplication occurence

 */
public class LC26_LC80_RemoveDuplicatesFromSortedArrayI_II {

    // I: do not allow any duplicate
    public static int removeDuplicates(int[] nums) {

        int j = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[j]){
                nums[++j] = nums[i];
            }
        }

        return ++j;
    }


    // II: allow at most 2 occurence for each duplicated value
    public static int removeDuplicates2(int[] nums) {

        int j = 0;
        int duplicationOccurence = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[j]){
                duplicationOccurence++;
                if(duplicationOccurence <= 2) {
                    nums[++j] = nums[i];
                }
            }else{
                duplicationOccurence = 1;
                nums[++j] = nums[i];
            }
        }

        return ++j;
    }

    public static void main(String[] args){

        // I
        int[] nums = {1, 1, 2, 3, 3, 4};
        int j = removeDuplicates(nums);
        int[] newNums = Arrays.copyOf(nums, j);
        Utils.printArray(newNums);

        // II
        int[] nums2 = {1, 1, 1, 2, 2, 3};
//        int[] nums2 = {1};
//        int[] nums2 = {1, 2, 2, 2};
        int j2 = removeDuplicates2(nums2);
        int[] newNums2 = Arrays.copyOf(nums2, j2);
        Utils.printArray(newNums2);
    }
}
