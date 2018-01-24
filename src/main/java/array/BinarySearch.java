package array;

/**
 * Created by ruili1 on 12/6/17.
 */
public class BinarySearch {

    public static int binarySearch(int[] nums, int start, int end, int target){

        while(start <= end){
            int mid = (start + end)/2;
            if(target < nums[mid]){
                end = mid - 1;
            }else if(target == nums[mid]){
                return mid;
            }else{
                start = mid + 1;
            }
        }

        return -1;
    }
}
