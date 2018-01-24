package binarysearch;

import java.util.Arrays;

/**
 * Created by ruili1 on 1/6/18.
 *
 * Given an integer array, return the k-th smallest distance among all the pairs. The distance of a pair (A, B) is defined as the absolute difference between A and B.

 Example 1:
 Input:
 nums = [1,3,1]
 k = 1
 Output: 0
 Explanation:
 Here are all the pairs:
 (1,3) -> 2
 (1,1) -> 0
 (3,1) -> 2
 Then the 1st smallest distance pair is (1,1), and its distance is 0.

 Note:
 2 <= len(nums) <= 10000.
 0 <= nums[i] < 1000000.
 1 <= k <= len(nums) * (len(nums) - 1) / 2.

 -----
 solution:

 */
public class LC719_FindKthSmallestPairDistance {

    private static int count(int [] nums, int maxDiff){

        int len = nums.length;

        int count = 0;
        for(int i = 0; i < len - 1; i++){
            int j = i + 1;
            while(j < len && nums[j] - nums[i] <= maxDiff) {
                j++;
            }
            count += j-1-i;
        }
        return count;
    }

    public static int smallestDistancePair(int[] nums, int k) {

        if(nums.length <= 1){
            return 0;
        }

        Arrays.sort(nums);

        // get highest difference and lowest difference
        int low = nums[1] - nums[0];
        for(int i = 1; i < nums.length - 1; i++){
            if(nums[i+1] - nums[i] < low){
                low = nums[i+1] - nums[i];
            }
        }
        int high = nums[nums.length-1] - nums[0];

        while(low < high){
            int mid = low + (high - low)/2;
            int count = count(nums, mid);
            if(count < k){
                low = mid + 1;
            }else{
                high = mid;
            }
        }

        return low;
    }

    public static void main(String[] args){

        int[] nums =   {1,3,1}; //{1,3,6}; //
        int k = 3;
        System.out.println(smallestDistancePair(nums, k));

    }

}
