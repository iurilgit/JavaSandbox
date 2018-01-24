package array;

import sun.tools.java.BinaryCode;

import java.util.*;

/**
 * Created by ruili1 on 12/3/17.
 *
 * Given a set of distinct integers, nums, return all possible subsets (the power set).

 Note: The solution set must not contain duplicate subsets.

 For example,
 If nums = [1,2,3], a solution is:

 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]

 */
public class LC78_Subsets {

    /**
     * Solution 1: using backtracking
     * @param nums
     * @return
     */

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<Integer>(), nums, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<Integer>(tempList));
        for(int i = start; i < nums.length; i++){
//            System.out.println("i: " + i);
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
//        System.out.println("list: " + list);
//        System.out.println("templist: " + tempList);
    }

    /**
     * Solution 2: using bit manipulation
     */
    public static List<List<Integer>> subsetsBitManipulation(int[] nums) {

        int len = nums.length;

        // based on the number of unique numbers (len), loop through the binary num from 0 ~ 2^len.
        // pick the corresponding number if a bit == 1, do not pick the number if bit == 0
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for(int i = 0; i < Math.pow(2, len); i++){
            char[] binaryCharArray = Integer.toBinaryString(i).toCharArray();
            int binaryLen = binaryCharArray.length;
            int startIdxInOrgArray = len - binaryLen;
            List<Integer> set = new ArrayList<Integer>();
            for(int j = 0; j < binaryLen; j++){
                if(binaryCharArray[j] == '1'){
                    set.add(nums[startIdxInOrgArray + j]);
                }
            }
            list.add(set);
        }

        return list;
    }

    public static void main(String[] args){

        int nums[] = {1, 2, 3};
        List<List<Integer>> subsets = subsetsBitManipulation(nums);
        System.out.println(subsets);
    }
}
