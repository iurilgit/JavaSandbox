package dp;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ruili1 on 10/1/17.
 */
public class LC679_24Game2 {

    public static boolean judgePoint24(int[] nums) {

        return combinations(nums).contains(24);
    }

    private static Set<Integer> combinations(int[] nums) {

        Set<Integer> set = new HashSet<Integer>();
        if (nums.length == 1) {
            set.add(nums[0]);
            return set;
        }

        for(int i = 0; i < nums.length; i++){
            int[] rest = getRestNums(nums, i);
            for(int j = 0; j < rest.length; j++){
                rest = getRestNums(rest, j)
                ;
            }
        }

        return set;
    }

    private static int[] getRestNums(int[] nums, int k){

        int[] rest = new int[nums.length - 1];
        int i = 0;
        for(int j = 0; j < nums.length; j++){
            if(j != k){
                rest[i++] = nums[j];
            }
        }

        return rest;
    }

    private static String printArray(int[] nums){

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int num : nums){
            sb.append(num);
            sb.append(", ");
        }

        String s = sb.substring(0, sb.length() - 2);
        return s + "]";
    }

    public static void main(String[] args){

//        int[] nums = {4, 1, 8, 7};
//        int[] nums = {1, 2, 3, 4};
        int[] nums = {1, 2, 1, 2};
        System.out.println(judgePoint24(nums));
    }
}
