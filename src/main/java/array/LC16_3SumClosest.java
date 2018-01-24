package array;

import java.util.Arrays;

/**
 * Created by ruili1 on 12/1/17.
 *
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.

 For example, given array S = {-1 2 1 -4}, and target = 1.

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

 ------
 Solution:
 Similar to the idea of 3Sum. But you don't need to worry about duplicated numbers.
 Plus the scanning can be reduced.
 O(N^2)
 */
public class LC16_3SumClosest {

    public static int threeSumClosest(int[] nums, int target) {

        int res;
        if(nums.length >= 3){
            res = nums[0] + nums[1] + nums[2];
        }else{
            if(nums.length == 2){
                res = nums[0] + nums[1];
            }else if(nums.length == 1){
                res = nums[0];
            }else{
                res = 0;
            }
            return res;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length -2; i++){
            int lo = i+1;
            int hi = nums.length-1;
            while(lo < hi){
                int sum = nums[i] + nums[lo] + nums[hi];
                if(Math.abs(sum - target) < Math.abs(res - target)){
                    res = sum;
                }
                if(sum == target){
                    return sum;
                }
                if(sum < target){
                    lo++;
                }else {
                    hi--;
                }
            }
        }

        return res;
    }

    public static void main(String[] args){

        int[] nums = {-1, 2, 1,-4};
        System.out.println(threeSumClosest(nums, 1));
    }
}
