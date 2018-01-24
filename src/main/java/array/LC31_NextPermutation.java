package array;

/**
 * Created by ruili1 on 12/3/17.
 *
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

 If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

 The replacement must be in-place, do not allocate extra memory.

 Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 1,2,3 → 1,3,2
 3,2,1 → 1,2,3
 1,1,5 → 1,5,1

 ------
 Solution:
 - scan from end to start, find the first i where nums[i] < nums[i+1] (it breaks the descending order).
 Then swap these two numbers. If the whole array is descending order, the reverse the whole thing.

 */
public class LC31_NextPermutation {

    public static void nextPermutation(int[] nums) {

        int len = nums.length;
        int i;
        for(i = len - 2; i >= 0; i--){
            if(nums[i] < nums[i+1]){
                break;
            }
        }

        if(i >= 0){ // the whole array is not completely descending ordered
            // find the first value (from end) that is larger than nums[i]
            // and swap it with nums[i]
            // this makes sure that the array from i+1 to end is reversed,
            // so reverse it into the first larger number than it.
            int j;
            for(j = len - 1; j >= i+1; j--){
                if(nums[j] > nums[i]){
                    break;
                }
            }
            swap(nums, i, j);
            // reverse the array from i+1 to end
            reverse(nums, i+1, len -1);
        }else{
            reverse(nums, 0, len-1);
        }
    }

    public static void swap(int[] nums, int i, int j){

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums, int i, int j){

        for(int k = 0; i+k < j-k; k++){
            swap(nums, i+k, j-k);
        }
    }

    public static void main(String[] args){

//        int[] nums = {3, 2, 1};
//        int[] nums = {1, 2, 1, 5, 4, 3, 3, 2, 1};
        int[] nums = {6,3,4,9,8,7,1};
        nextPermutation(nums);
        Utils.printArray(nums);
    }

}
