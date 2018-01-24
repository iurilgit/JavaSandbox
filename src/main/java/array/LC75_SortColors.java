package array;

/**
 * Created by ruili1 on 12/17/17.
 *
 * Given an array with n objects colored red, white or blue, sort them so that
 * objects of the same color are adjacent, with the colors in the order red, white and blue.

 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

 Note:
 You are not suppose to use the library's sort function for this problem.

 ---
 solution:
 1. two passes O(2N): keep 3 variables to keep track of the number of 0, 1 and 2. The reconstruct the array based on these 3 numbers
 2. one pass O(N): swap the 0s to the start and swap the 2s to the end. But the index handling is a bit tricky.
 */
public class LC75_SortColors {

    // solution 1
    public static void sortColors(int[] nums) {

        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                zeroCount++;
            }else if(nums[i] == 1){
                oneCount++;
            }else{
                twoCount++;
            }
        }

        System.out.println(zeroCount);
        System.out.println(oneCount);
        System.out.println(twoCount);

        int idx = 0;
        for(int i = 0; i < zeroCount; i++){
            nums[idx++] = 0;
        }
        for(int i = 0; i < oneCount; i++){
            nums[idx++] = 1;
        }
        for(int i = 0; i < twoCount; i++){
            nums[idx++] = 2;
        }
    }

    public static void sortColorsFaster(int[] nums){

        int j = 0;
        int k = nums.length - 1;
        for(int i = 0; i <= k; i++){
            if(nums[i] == 0){
                swap(nums, i, j++);
            }else if(nums[i] == 2){
                swap(nums, i--, k--);
            }
        }
    }

    private static void swap(int[] nums, int i, int j){

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args){
        int[] nums = {1, 0, 0, 2, 1, 0};
        sortColorsFaster(nums);
        Utils.printArray(nums);
    }
}
