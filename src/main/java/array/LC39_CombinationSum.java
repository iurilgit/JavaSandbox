package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by ruili1 on 12/8/17.
 *
 Given a set of candidate numbers (C) (without duplicates) and a target number (T),
 find all unique combinations in C where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.

 Note:
 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 For example, given candidate set [2, 3, 6, 7] and target 7,
 A solution set is:
 [
 [7],
 [2, 2, 3]
 ]

 -------
 solution:
 backtracking

 */
public class LC39_CombinationSum
{

    // recursive solution that works
//    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
//
//        List<List<Integer>> res = new ArrayList<List<Integer>>();
//
//        for(int candidate : candidates){
//            if(candidate == target){
//                List<Integer> list = new ArrayList<Integer>();
//                list.add(candidate);
//                res.add(list);
//            }else if(candidate < target){
//                List<List<Integer>> subResults = combinationSum(candidates, target - candidate);
//                for(List<Integer> subResult : subResults){
//                    subResult.add(candidate);
//                    Collections.sort(subResult);
//                    if(!res.contains(subResult)) {
//                        res.add(subResult);
//                    }
//                }
//            }
//        }
//
//        return res;
//    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);
        List<Integer> usedCandidatesIndices = new ArrayList<Integer>();
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        helper(results, candidates, usedCandidatesIndices, 0, target);

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
            tempList.add(candidate);
            helper(results, candidates, tempList, i + 1, target - candidate);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args){

        int[] candidates = {2, 3, 6, 7};
        List<List<Integer>> results = combinationSum(candidates, 7);
        for(List<Integer> result : results){
            System.out.println(result);
        }
    }
}
