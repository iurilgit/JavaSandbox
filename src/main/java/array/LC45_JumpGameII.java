package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ruili1 on 12/9/17.
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Your goal is to reach the last index in the minimum number of jumps.

 For example:
 Given array A = [2,3,1,1,4]

 The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

 Note:
 You can assume that you can always reach the last index.

 -------
 solution:
 - I came up with a DP solution, however, it's O(N*N) complexity and it times out on some cases
 - the answer key is a greedy solution (similar to the original jump game, except need to keep track of the steps

 */
public class LC45_JumpGameII {

    // DP solution, correct logic but it will time out
//    public static int jump2(int[] nums) {
//
//        int jumps = 0;
//        int[] solution = new int[nums.length];
//        Arrays.fill(solution, Integer.MAX_VALUE);
//        solution[0] = 0;
//        for(int i = 1; i < nums.length; i++){
//            for(int j = i - 1; j >= 0; j--){
//                if(nums[j] >= i - j){
//                    solution[i] = Math.min(solution[j] + 1, solution[i]);
//                }
//            }
//        }
//
//        return solution[nums.length - 1];
//    }

    // greedy solution (assumes it can always reach the end)
    public static int jump2(int[] nums){

        int steps = 0;
        int reachable = 0;
        int currEnd = 0; // at the current moment, what's last index it can reach
        for(int i = 0; i < nums.length - 1; i++){
            if(reachable < i){
                return -1;
            }else{
                reachable = Math.max(i+nums[i], reachable);
                if(i == currEnd){
                    currEnd = reachable;
                    steps++;
                }
            }
        }

        return steps;
    }

    // greedy solution (handle the case where it doens't reach the end: return -1)
    public static int jump3(int[] nums){

        int steps = 0;
        int reachable = 0;
        int currEnd = 0; // at the current moment, what's last index it can reach
        for(int i = 0; i < nums.length - 1; i++){
            if(reachable < i){
                return -1;
            }else{
                reachable = Math.max(i+nums[i], reachable);
                if(i == currEnd){
                    currEnd = reachable;
                    steps++;
                }
            }
        }

        if(reachable >= nums.length -1){
            return steps;
        }else{
            return -1;
        }
    }

    // instead of returning the # of steps, return the actual steps (in a list)
    public static List<Integer> jump4(int[] nums){

        List<Integer> steps = new ArrayList<Integer>();
        int reachable = 0;
        int currEnd = 0; // at the current moment, what's last index it can reach
        for(int i = 0; i < nums.length - 1; i++){  // key: not to check the last value in the array
            if(reachable < i){
                return null;
            }else{
                reachable = Math.max(i+nums[i], reachable);
                if(i == currEnd){
                    currEnd = reachable;
                    steps.add(reachable);
                }
            }
        }

        if(reachable >= nums.length -1){
            return steps;
        }else{
            return null;
        }
    }


    public static void main(String[] args){

//        int[] nums = {3, 2, 1, 0, 4}; //  can't reach the end
//        int[] nums = {2, 3, 1, 1, 4};
        int[] nums = {3, 2, 2, 1, 3, 1, 4};
        System.out.println(jump2(nums));
        System.out.println(jump3(nums));
        System.out.println(jump4(nums));

    }
}

