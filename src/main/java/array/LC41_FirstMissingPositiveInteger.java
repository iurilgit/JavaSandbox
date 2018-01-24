package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ruili1 on 10/4/17.
 *
 * Given an unsorted integer array, find the first missing positive integer.

 For example,
 Given [1,2,0] return 3,
 and [3,4,-1,1] return 2.

 Your algorithm should run in O(n) time and uses constant space.

 -----
 solution
 2. parse the whole array and put all positive numbers in a set, then the set becomes size N.
 then starting from 1, search 1, 2, 3,... N in the set. If anyone is missing, return it.
 Otherwise, return N+1
 3.
 */
public class LC41_FirstMissingPositiveInteger {

    // 1. This algo has O(n) space complexity and O(nlogn) time complexity
    public static int findSmallestPostiveInteger1(int[] nums){

        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){
            if(nums[i]> 1){
                if(i == 0){
                    return 1;
                }
                if(nums[i - 1] + 1 < nums[i]){
                    return nums[i - 1] + 1;
                }
            }
        }

        int lastNum = nums[nums.length - 1];
        return Math.max(lastNum, 0) + 1;
    }

    // 2. This algo has O(n) space complexity and O(n) time complexity
    public static int findSmallestPostiveInteger2(int[] nums){

        Set<Integer> set = new HashSet<Integer>();
        for(int num : nums){
            if(num >= 1) {
                set.add(num);
            }
        }

        for(int i = 1; i <= set.size(); i++){
            if(!set.contains(i)){
                return i;
            }
        }

        return set.size() + 1;
    }


    // 3. This algo has O(1) space complexity adn O(n) time complexity
    public static int findSmallestPostiveInteger3(int[] nums){

        // move all positive numbers to the left and record the number of positive numbers
        int positiveIntegerNum = movePositivesToLeft(nums);
        Utils.printArray(nums);
        System.out.println(positiveIntegerNum);

        // go through all positive numbers. If the number is positive, mark nums[1] = -nums[i]
        for(int i = 0; i < positiveIntegerNum; i++){
            if(Math.abs(nums[i]) <= nums.length){
                int loc = Math.abs(nums[i])- 1;
                nums[loc] = -1*Math.abs(nums[loc]);
                Utils.printArray(nums);
            }
        }
        Utils.printArray(nums);

        // skip the first value since it indicates whether 0 exists
        for(int i = 0; i < positiveIntegerNum; i++){
            if(nums[i] >= 0){
                return i + 1;
            }
        }

        return positiveIntegerNum + 1;
    }

    // move all positive integers to the left in the array
    private static int movePositivesToLeft(int nums[]){

        int len = nums.length;

        int left = 0;
        int right = len - 1;

        while(left <= right){
            while(left < len && nums[left] >= 1){
                left++;
            }

            while(right >= 0 && nums[right] < 1){
                right--;
            }

            if(left < right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }

        return left;
    }

    // swap element i and j in array nums
    private static void swap(int[] nums, int i, int j){

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args){

//        int[] nums = {-2,0,1,5};
//        int[] nums = {2, 3, 4};
//        int[] nums = {0, 1};
//        int[] nums = {-1, 0};
//        int[] nums = {-5, -3, -1};
        int[] nums = {0,2,5,2,1,3};
//        int[] nums = {2};
//        int[] nums = {0};

        System.out.println(findSmallestPostiveInteger3(nums));
    }
}
