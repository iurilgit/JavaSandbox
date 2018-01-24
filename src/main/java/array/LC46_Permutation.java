package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by ruili1 on 12/5/17.
 *
 * Given a collection of distinct numbers, return all possible permutations.

 For example,
 [1,2,3] have the following permutations:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]

 ------
 Solution:
 backtracking
 Pick each element as the first element
 */
public class LC46_Permutation {

    static void swap(int a[], int l, int r) {
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }

    static void helper(int a[], int l, int r, List<List<Integer>> res) {
        if (l == r) {
            List<Integer> list = new ArrayList<Integer>();
            for(int val : a){
                list.add(val);
            }

            res.add(list);
        }else {
            for (int i = l; i <= r; i++) {
                swap(a, l, i);
                helper(a, l + 1, r, res);
                swap(a, l, i); // backtrack
            }
        }
    }

    public static List<List<Integer>> permute(int[] nums){

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(nums, 0, nums.length-1, res);
        return res;
    }

    public static void main(String[] args){

        int[] nums = {1, 2, 3};
        List<List<Integer>> res = permute(nums);
        for(List<Integer> r : res){
            System.out.println(r);
        }

    }
}
