package binarysearch;

/**
 * Created by ruili1 on 12/6/17.
 *
 * Variation of LC33, but it can contain duplicates.
 *
 * --
 * Solution:
 * check 3 scenarios:
 * - 1st half ascending, 2nd half descending
 * - 1st half descending, 2nd half ascending
 * - 2st half and 2nd half both have the same start and end, which can't decide which half is not in order,
 * so recursively check both half
 */
public class LC81_SearchRotatedArrayII {

    public static boolean search(int[] nums, int target) {

        return helper(nums, 0, nums.length - 1, target);
    }

    public static boolean helper(int[] nums, int start, int end, int target){

        while(start <= end) {
            int mid = (start + end) / 2;
            if(nums[mid] == target){
                return true;
            }

            if(nums[start] < nums[mid] && nums[mid] > nums[end]){ // 1st half is sorted but 2nd half is not
                if (target >= nums[start] && target < nums[mid]) { // target falls into 1st half, regular binary searchRange
                    end = mid - 1;
                } else{
                    return helper(nums, mid+1, end, target);
                }
            }else if(nums[mid] < nums[end] && nums[start] > nums[mid]){ // 2nd half is sorted but 1st half is not
                if(target > nums[mid] && target <= nums[end]) { // target falls into 2nd half, regular binary searchRange
                    start = mid + 1;
                }else{
                    return helper(nums, start, mid-1, target);
                }
            }else{ // nums[start] == nums[mid] == nums[end]
                return helper(nums, start, mid-1, target) || helper(nums, mid+1, end, target);
            }
        }

        return false;
    }

    public static void main(String[] args){

        int[] nums1 = {1, 1};
        System.out.println(search(nums1, 0)); // false
        System.out.println(search(nums1, 1)); // true

        int[] nums2 = {3, 1, 1};
        System.out.println(search(nums2, 0));  // false

        int[] nums3 = {6, 6, 7, 0, 1, 1, 2, 4, 5, 5,};
        System.out.println(search(nums3, 4)); // true
        System.out.println(search(nums3, 3)); // false
        System.out.println(search(nums3, 1)); // true
        System.out.println(search(nums3, 6)); // true

        int[] nums4 = {1,1,3,1,1,1,1,1,1,1,1,1};
        System.out.println(search(nums4, 1)); // true
        System.out.println(search(nums4, 3)); // true

        int[] nums5 = {1,1,3,1};
        System.out.println(search(nums5, 1)); // true
        System.out.println(search(nums5, 3)); // true
    }
}
