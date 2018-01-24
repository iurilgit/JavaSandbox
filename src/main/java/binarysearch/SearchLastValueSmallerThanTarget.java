package binarysearch;

/**
 * Created by ruili1 on 1/6/18.
 *
 * A variation of LC35,
 */
public class SearchLastValueSmallerThanTarget {

    public static int findLastValueSmallerThanTarget(int[] nums, int target){

        if(nums.length == 0 || target <= nums[0]){
            return -1;
        }

        int left = 0;
        int right = nums.length -1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public static void main(String[] args){

        int[] nums = {0, 1, 1, 3, 3, 5, 8};
        System.out.println(findLastValueSmallerThanTarget(nums, 0)); // -1
        System.out.println(findLastValueSmallerThanTarget(nums, 2)); // 2
        System.out.println(findLastValueSmallerThanTarget(nums, 3)); // 2
        System.out.println(findLastValueSmallerThanTarget(nums, 5)); // 4
        System.out.println(findLastValueSmallerThanTarget(nums, 7)); // 5

    }
}
