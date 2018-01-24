package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ruili1 on 12/4/17.
 *
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

 Note: The solution set must not contain duplicate subsets.

 For example,
 If nums = [1,2,2], a solution is:

 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]

 solution:
 - backtracking or bit manipulation
 */
public class LC90_SubestsII {

    public static List<List<Integer>> subsetsBitManipulation(int[] nums) {

        Arrays.sort(nums); // to handle duplicated values
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
            // make sure not to add duplicated set
            if(!list.contains(set)) {
                list.add(set);
            }
        }

        return list;
    }

    public static void main(String[] args){

        int nums[] = {1, 2, 2};
        List<List<Integer>> subsets = subsetsBitManipulation(nums);
        System.out.println(subsets);
    }
}
