package array;

/**
 * Created by ruili1 on 9/15/17.
 *
 * Given an array of size n, find the majority element. The majority element is the element
 * that appears more than ⌊ n/2 ⌋ times.

 You may assume that the array is non-empty and the majority element always exist in the array.

 ---
 Idea:

 Moore voting: since this is looking for occurence > n/2, we can use this algo.
 If there is no such condition, then we can use hash table.

 */
public class LC169_MajorityElement {

    public static int majorityElement(int[] nums) {

        int majority = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == majority){
                count ++;
            }else{
                if(count == 0){
                    majority = nums[i];
                    count = 1;
                }else{
                    count --;
                }
            }
        }

        return majority;
    }

    public static void main(String[] args){

        int[] nums = {1, 3, 2, 3, 1, 3, 3};
        System.out.println(majorityElement(nums));

    }
}
