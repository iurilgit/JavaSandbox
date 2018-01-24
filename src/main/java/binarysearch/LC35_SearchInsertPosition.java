package binarysearch;

/**
 * Created by ruili1 on 12/8/17.
 *
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.

 Example 1:

 Input: [1,3,5,6], 5
 Output: 2
 Example 2:

 Input: [1,3,5,6], 2
 Output: 1
 Example 3:

 Input: [1,3,5,6], 7
 Output: 4
 Example 1:

 Input: [1,3,5,6], 0
 Output: 0

 ----------
 solution1:
 binary search + a variable to keep track of the minimum of the larger values.
 It should be able to handle duplicated values.

 solution2:
 simple binary search, at the end left would be the return value.
 */
public class LC35_SearchInsertPosition {

    public static int searchInsert1(int[] nums, int target) {

        int minOfLargerValues = Integer.MAX_VALUE;
        int indexToInsert = nums.length;

        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (left + right)/2;
            if(nums[mid] >= target){
                if(nums[mid] < minOfLargerValues){
                    minOfLargerValues = nums[mid];
                    indexToInsert = mid;
                    right = mid - 1;
                }
            }else{
                left = mid + 1;
            }
        }

        return indexToInsert;
    }


    // simpler version
    public static int searchInsert2(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }


    public static void main(String[] args){

        int[] nums = {0, 1, 1, 3, 3, 5, 8}; // {1,3,5,6};
        System.out.println(searchInsert2(nums, 0));
        System.out.println(searchInsert2(nums, 2));
        System.out.println(searchInsert2(nums, 3));
        System.out.println(searchInsert2(nums, 5));
        System.out.println(searchInsert2(nums, 7));

    }

}
