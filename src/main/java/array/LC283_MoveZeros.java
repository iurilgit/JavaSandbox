package array;

/**
 * Created by ruili1 on 9/17/17.
 *
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

 For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

 Note:
 You must do this in-place without making a copy of the array.
 Minimize the total number of operations.

 */
public class LC283_MoveZeros {

    public static void moveZeroes(int[] nums) {

        int idx = 0;
        for(int num : nums){
            if(num != 0) {
                nums[idx++] = num;
            }
        }

        for(int i = idx; i < nums.length; i++){
            nums[i] = 0;
        }
    }

    public static void main(String[] args){

        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        for(int num : nums){
            System.out.println(num + ", ");
        }
    }
}
