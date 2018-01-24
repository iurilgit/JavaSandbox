package dp;

/**
 * Created by ruili1 on 9/17/17.
 *
 * Find the contiguous subarray within an array (containing at least one number) which
 * has the largest sum.

 For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 the contiguous subarray [4,-1,2,1] has the largest sum = 6.


 */
public class LC53_MaxSubarray {

    public static int maxSubArray(int[] nums) {

        if (nums.length == 0){
            return 0;
        }

        int bestStartIdx = 0;
        int currMaxSum = nums[0];
        int globalMaxSum = currMaxSum;
        for(int i = 1; i < nums.length; i++){
            if(currMaxSum < 0){    // the current sub array has negative sum, start with a new sub array
                bestStartIdx = i;
                currMaxSum = nums[i];
            }else{
                currMaxSum += nums[i];
            }
            globalMaxSum = Math.max(globalMaxSum, currMaxSum);
        }

        return globalMaxSum;
    }

    public static void main(String[] args){

        int[] nums = {1, 2}; //{-2,1,-3,4,-1,2,1,-5,4}; //
        System.out.println(maxSubArray(nums));
    }
}
