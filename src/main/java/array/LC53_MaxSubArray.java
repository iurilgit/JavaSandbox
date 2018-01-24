package array;

/**
 * Created by ruili1 on 10/3/17.
 *
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

 For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 the contiguous subarray [4,-1,2,1] has the largest sum = 6.

 -------------
 solution:
 1. an iterative way of solution 2. but advantage is it can give the starting of the subarray.
 2. dp solution. dp[i] records the max sum including num[i]. dp[i] = max(dp[i-1]+ nums[i], nums[i]).
 */
public class LC53_MaxSubArray {

    public static int maxSubArray(int[] nums) {

        if (nums.length == 0){
            return 0;
        }

        int bestStartIdx = 0;
        int currMaxSum = nums[0];
        int globalMaxSum = currMaxSum;
        for(int i = 1; i < nums.length; i++){
            currMaxSum += nums[i];
            if(currMaxSum < nums[i]){    // the current sub array has sum smaller than the curr value, start with a new sub array
                bestStartIdx = i;
                currMaxSum = nums[i];
            }
            globalMaxSum = Math.max(globalMaxSum, currMaxSum);
        }

        return globalMaxSum;
    }

    // dp solution
    public static int maxSubArray2(int[] nums) {

        if (nums.length == 0){
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int globalMaxSum = dp[0];
        for(int i = 1; i < nums.length; i++){
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
            globalMaxSum = Math.max(globalMaxSum, dp[i]);
        }

        return globalMaxSum;
    }

    public static void main(String[] args){

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArray2(nums));


    }

}
