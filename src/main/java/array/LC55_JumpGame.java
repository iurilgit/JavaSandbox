package array;

/**
 * Created by ruili1 on 12/9/17.
 *
 Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Determine if you are able to reach the last index.

 For example:
 A = [2,3,1,1,4], return true.

 A = [3,2,1,0,4], return false.

 -------
 solution:
 1. intuitive way: recursive way from end
 2. define a global variable called "reachable" to tell the furthest idx it can reach at any location.
 If at any location i, reachable is smaller than i, then return false.

 */
public class LC55_JumpGame {

    // recursive solution, but will time out
//    public static boolean canJump(int[] nums) {
//
//        return helper(nums, nums.length -1);
//    }
//
//    public static boolean helper(int[] nums, int end){
//
//        if(end == 0){
//            return true;
//        }
//
//        for(int i = end - 1; i >= 0; i--){
//            if(nums[i] >= (end - i) && helper(nums, i)){
//                return true;
//            }
//        }
//        return false;
//    }

    public static boolean canJump(int[] nums) {
        // Greedy solution: referenced the answers

        int reachable = 0;
        for(int i = 0; i < nums.length; i++){
            if(reachable < i){
                return false;
            }else{
                reachable = Math.max(i+nums[i], reachable);
            }
        }

        return true;
    }


    public static boolean canJump2(int[] nums) {
        // another solution: scan from end to start. If there is a 0, scan numbers before it to see it can jump over the zero.
        // If it can, check the next 0. If it can't jump over any of the zeros, return false.

        Integer indexOfNextZero = -1;
        boolean canJumpOverNextZero = false;
        for(int i = nums.length - 1; i>= 0; i--){
            if((indexOfNextZero == null && nums[i] == 0)){
                indexOfNextZero = i;
                canJumpOverNextZero = false;
            }
            if(indexOfNextZero != null && nums[i] + i > indexOfNextZero){
                indexOfNextZero = null;
                canJumpOverNextZero = true;
            }
        }

        return canJumpOverNextZero;
    }

    public static void main(String[] args){

//        int[] nums = {2,3,1,1,4};
//        int[] nums = {3,2,1,0,4};
        int[] nums = {2,0,6,9,8, 4, 5, 0, 8, 9, 1, 2, 9, 6, 8, 8, 0, 6, 3, 1,
                2, 2, 1, 2, 6, 5, 3, 1, 2, 2, 6, 4, 2, 4, 3, 0, 0, 0, 3, 8, 2,
                4, 0, 1, 2, 0, 1, 4, 6, 5, 8, 0, 7, 9, 3, 4, 6, 6, 5, 8, 9, 3,
                4, 3, 7, 0, 4, 9, 0, 9, 8, 4, 3, 0, 7, 7, 1, 9, 1, 9, 4, 9, 0,
                1, 9, 5, 7, 7, 1, 5, 8, 2, 8, 2, 6, 8, 2, 2, 7, 5,1,7,9,6};
        System.out.println(canJump(nums));
        System.out.println(canJump2(nums));
    }
}
