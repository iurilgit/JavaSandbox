package binarysearch;

/**
 * Created by ruili1 on 12/5/17.
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 You are given a target value to searchRange. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.

 ------
 solution:
 - modified binary searchRange idea:
 one half must be sorted. if target falls in that half, dp regular binary searchRange on that half,
 otherwise, do recursive searchRange on the other half.
 *
 */
public class LC33_SearchInRotatedArray {

    public static int search(int[] nums, int target) {

        return helper(nums, 0, nums.length - 1, target);
    }

    public static int helper(int[] nums, int start, int end, int target){

        while(start <= end) {
            int mid = (start + end) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] <= nums[end]){ // 2nd half is sorted
                if(target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                }else{
                    return helper(nums, start, mid-1, target);
                }
            }else{ // 1st half is sorted
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else{
                    return helper(nums, mid+1, end, target);
                }
            }
        }

        return -1;
    }

    public static void main(String[] args){

        int[] nums1 = {1};
        System.out.println(search(nums1, 0)); // -1
        System.out.println(search(nums1, 1)); // 0

        int[] nums2 = {3, 1};
        System.out.println(search(nums2, 0));  // -1

        int[] nums3 = {6, 7, 0, 1, 2, 4, 5,};
        System.out.println(search(nums3, 4)); //5
        System.out.println(search(nums3, 3)); //-1
        System.out.println(search(nums3, 1)); //3
        System.out.println(search(nums3, 6)); //0

        int[] nums4 = {2, 4, 5, 6, 7, 0, 1};
        System.out.println(search(nums4, 4)); // 1
        System.out.println(search(nums4, 3)); // -1
        System.out.println(search(nums4, 1)); // 6
        System.out.println(search(nums4, 6)); // 3
    }
}
