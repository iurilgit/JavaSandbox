package binarysearch;

/**
 * Created by ruili1 on 1/6/18.
 */
public class SearchFirstValueLargerThanTarget {

    public static int findFirstValueLargerThanTarget(int[] nums, int target){

        if(nums.length == 0 || target >= nums[nums.length - 1]){
            return -1;
        }

        int left = 0;
        int right = nums.length -1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args){

        int[] nums = {0, 1, 1, 3, 3, 5, 8};
        System.out.println(findFirstValueLargerThanTarget(nums, 0)); // 0
        System.out.println(findFirstValueLargerThanTarget(nums, 2)); // 3
        System.out.println(findFirstValueLargerThanTarget(nums, 3)); // 3
        System.out.println(findFirstValueLargerThanTarget(nums, 5)); // 5
        System.out.println(findFirstValueLargerThanTarget(nums, 8)); // -1

    }

}
