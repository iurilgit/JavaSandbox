package array;

/**
 * Created by ruili1 on 12/30/17.
 *
 A peak element is an element that is greater than its neighbors.

 Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

 The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

 You may imagine that num[-1] = num[n] = -∞.

 For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

 ------
 solution:
 1. O(N): go through the array from idx 1 to len-2 (inclusive) and return a one that satisfies the condition
 2. O(logN): binary search

 */
public class LC162_FindPeakElement {

    public static int findPeakElement2(int[] nums) {

        int len = nums.length;

        int left = 0;
        int right = len - 1;
        int mid = 0;
        while(left <= right){
            mid = (left + right)/2;
            boolean greaterThanLeft = mid == 0? true : nums[mid] > nums[mid-1];
            boolean greaterThanRight = mid == len -1? true : nums[mid] > nums[mid+1];

            if(greaterThanLeft && greaterThanRight){
                return mid;
            }else if(!greaterThanLeft){
                right = mid -1;
            }else{
                left = mid + 1;
            }
        }
        return mid;
    }

    public static void main(String[] args){

//        int[] nums = {1, 2, 3, 1};
        int[] nums = {1};
        System.out.println(findPeakElement2(nums));
    }
}
