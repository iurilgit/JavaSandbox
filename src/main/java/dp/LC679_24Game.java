package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ruili1 on 10/1/17.
 *
 * You have 4 cards each containing a number from 1 to 9.
 * You need to judge whether they could operated through *, /, +, -, (, ) to get the value of 24.

 Example 1:
 Input: [4, 1, 8, 7]
 Output: True
 Explanation: (8-4) * (7-1) = 24
 Example 2:
 Input: [1, 2, 1, 2]
 Output: False
 Note:
 The division operator / represents real division, not integer division. For example, 4 / (1 - 2/3) = 12.
 Every operation done is between two numbers. In particular, we cannot use - as a unary operator.
 For example, with [1, 1, 1, 1] as input, the expression -1 - 1 - 1 - 1 is not allowed.
 You cannot concatenate numbers together. For example, if the input is [1, 2, 1, 2], we cannot write this as 12 + 12.
 */
public class LC679_24Game {

    public static boolean judgePoint24(int[] nums) {

        float[] floats = new float[nums.length];
        for(int i = 0; i < nums.length; i++){
            floats[i] = (float)nums[i];
        }
        return judgePoint(floats, 24);
    }

    private static boolean judgePoint(float[] nums, float goal){

        if(nums.length == 1) {
            if (Math.abs(nums[0] - goal) < 0.000001) {
                System.out.println(printArray(nums) + goal + " self");
                return true;
            } else {
                return false;
            }
        }

        boolean res = false;
        for(int i = 0; i < nums.length; i++){
            float[] rest = getRestNums(nums, i);

            // multiplication
            res = judgePoint(rest, goal/nums[i]);
            if(res){
                System.out.println(printArray(nums) + goal + " mul");
                return true;
            }

            // divide
            res = judgePoint(rest, goal*nums[i]);
            if(res){
                System.out.println(printArray(nums) + goal + " divide");
                return true;
            }

            // add
            res = judgePoint(rest, goal + nums[i]);
            if(res){
                System.out.println(printArray(nums) + goal + " add");
                return true;
            }

            // minus
            res = judgePoint(rest, goal - nums[i]);
            if(res){
                System.out.println(printArray(nums) + " " + goal + " minus");
                return true;
            }
        }
        return false;
    }

    private static float[] getRestNums(float[] nums, int k){

        float[] rest = new float[nums.length - 1];
        int i = 0;
        for(int j = 0; j < nums.length; j++){
            if(j != k){
                rest[i++] = nums[j];
            }
        }

        return rest;
    }

    private static String printArray(float[] nums){

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(float num : nums){
            sb.append(num);
            sb.append(", ");
        }

        String s = sb.substring(0, sb.length() - 2);
        return s + "]";
    }

    public static void main(String[] args){

//        int[] nums = {4, 1, 8, 7};
//        int[] nums = {1, 2, 3, 4};
//        int[] nums = {1, 2, 1, 2};
        int[] nums = {6, 1, 3, 4};
        System.out.println(judgePoint24(nums));
    }
}
