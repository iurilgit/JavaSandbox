package array;

import java.util.*;

/**
 * Created by ruili1 on 12/9/17.
 *
 * Given a collection of candidate numbers (C) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.

 Each number in C may only be used once in the combination.

 Note:
 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 A solution set is:
 [
 [1, 7],
 [1, 2, 5],
 [2, 6],
 [1, 1, 6]
 ]

 Different from the LC39_CombinationSum, each number can only be used once.

 ------
 solution:
 same as combination sum, except we need to skip checking the candidate if the previous candidate is the same

 */
public class LC40_CombinationSumII {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        List<Integer> tempList = new ArrayList<Integer>();
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        helper(results, candidates, tempList, 0, target);

        return results;
    }

    public static void helper(List<List<Integer>> results, int[] candidates, List<Integer> tempList, int start, int target) {

        if(target == 0){
            results.add(new ArrayList<Integer>(tempList)); // very important to make a deep copy of the list
            return;
        }

        if(target < 0){
            return;
        }

        for(int i = start; i < candidates.length; i++){
            int candidate = candidates[i];
            if(i > start && candidate == candidates[i-1]){
                continue;
            }
            tempList.add(candidate);
            helper(results, candidates, tempList, i + 1, target - candidate);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args){

//        int[] candidates = {1, 2}; // 4
//        int[] candidates = {2, 3, 6, 7}; // 7
//        int[] candidates ={10, 1, 2, 7, 6, 1, 5}; // 8
        int[] candidates ={13,23,25,11,7,26,14,11,27,27,26,12,8,20,22,34,
                27,17,5,26,31,11,16,27,13,20,29,18,7,14,13,15,25,25,
                21,27,16,22,33,8,15,25,16,18,10,25,9,24,7,32,15,26,30,19,25};
        List<List<Integer>> results = combinationSum2(candidates, 25);
        for(List<Integer> result : results){
            System.out.println(result);
        }
    }

}
