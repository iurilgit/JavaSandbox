package bitmanipulation;

/**
 * Created by ruili1 on 12/31/17.
 *
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

 Example 1

 Input: [3,0,1]
 Output: 2
 Example 2

 Input: [9,6,4,2,3,5,7,0,1]
 Output: 8

 -----
 solution:
 1. calculate the sum of integers from 0-n, then subtract each number from the array. The remainder is the missing num
 2. due to the property of xor, if you xor the same number twice, it becomes 0. if you xor a number to 0, it's itself.
 so, xor everything from 0-n, then xor everything from the array. all the existing numbers cancels out.
 Then the leftover is the missing number.

 */
public class LC268_MissingNumber {

    // sum version, but it might have a overflow issue
    public static int missingNumber1(int[] nums) {

        int n = nums.length;
        int sum = n*(n+1)/2;
        int miss = sum;
        for(int num : nums){
            miss -= num;
        }
        return miss;
    }

    // xor version
    public static int missingNumber2(int[] nums) {

        int n = nums.length;

        int res = 0;  // this is important! it can't be 1
        for(int i = 0; i <= n; i++){
            res ^= i;
        }
        for(int num : nums){
            res ^= num;
        }
        return res;
    }

    public static void main(String[] args){

        int[] nums = {9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber1(nums));
        System.out.println(missingNumber2(nums));
    }
}
