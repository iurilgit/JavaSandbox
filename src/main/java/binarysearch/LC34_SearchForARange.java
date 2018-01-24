package binarysearch;

import array.Utils;

/**
 * Created by ruili1 on 12/7/17.
 *
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].

 ------
 solution:
 leverage "SearchLastValueSmallerThanTarget" and "SearchFirstValueLargerThanTarget"
 to find the two boundaries.

 */
public class LC34_SearchForARange {

    public static int[] searchRange(int[] nums, int target) {

        return helper(nums, 0, nums.length - 1, target);
    }

    public static int[] helper(int[] nums, int left, int right, int target){

        int leftOrg = left;
        int rightOrg = right;

        // search for starting index "start"
        int start = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                if (mid < start) {
                    start = mid;
                }
                right = mid - 1;
            } else if (nums[mid] < target) { // in 2nd half
                left = mid + 1;
            } else { // in 1st half
                right = mid - 1;
            }
        }

        // search for ending index "end"
        left = start == Integer.MAX_VALUE? leftOrg : start;
        right = rightOrg;
        int end = Integer.MIN_VALUE;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                if (mid > end) {
                    end = mid;
                }
                left = mid + 1;
            } else if (nums[mid] < target) { // in 2nd half
                left = mid + 1;
            } else { // in 1st half
                right = mid - 1;
            }
        }

        int[] res = {-1, -1};
        if(start < Integer.MAX_VALUE){
            res[0] = start;
        }
        if(end > Integer.MIN_VALUE){
            res[1] = end;
        }

        return res;
    }

    public static void main(String[] args){

        int[] nums1 = {1, 2, 2, 4};
        Utils.printArray(searchRange(nums1, 2)); // [1,2]
    }
}
