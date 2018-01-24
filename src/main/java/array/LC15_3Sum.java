package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ruili1 on 11/30/17.
 *
 * Given an array S of n integers, are there elements a, b, c in S
 * such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Note: The solution set must not contain duplicate triplets.

 For example, given array S = [-1, 0, 1, 2, -1, -4],

 A solution set is:
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]

 Solution:
 - if brute force, it's O(N^3)
 - so, sort it, then go through each element and make nums[i] the potential first member of the triple.
 Then go through the right half of the sorted array from 2 ends so their sum = 0 - nums[i].

 Make sure to skip the duplicated numbers once a solution is found.

 */
public class LC15_3Sum {

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();

        Arrays.sort(nums);

        for(int i = 0; i < nums.length -2; i++){
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])) { // skip duplicates
                if (nums[i] > 0) {
                    break;
                }
                int lo = i + 1;
                int hi = nums.length - 1;
                int sum = 0 - nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        res.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[lo], nums[hi])));
                        // skip duplicates
                        while(lo < hi && nums[lo] == nums[lo+1]){
                            lo++;
                        }
                        while(lo < hi && nums[hi] == nums[hi-1]){
                            hi--;
                        }
                        lo++;
                        hi--;
                    } else if (nums[lo] + nums[hi] < sum) {
                        lo++;
                    } else
                        hi--;
                }
            }
        }

        return res;
    }

    public static void main(String[] args){

//        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {0, 0, 0, 0};
//        int[] nums = {1, -1, -1, 0};
        List<List<Integer>> res = threeSum(nums);
        for(List<Integer> subRes : res){
            System.out.println(subRes);
        }
    }
}
