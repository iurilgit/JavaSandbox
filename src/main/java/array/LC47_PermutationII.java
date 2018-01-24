package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ruili1 on 12/5/17.
 *
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

 For example,
 [1,1,2] have the following unique permutations:
 [
 [1,1,2],
 [1,2,1],
 [2,1,1]
 ]

 Notes:
 This is a small variation from LC46_Permutation
 */
public class LC47_PermutationII {

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
            if(!res.contains(list)) {
                res.add(list);
            }
        }else {
            for (int i = l; i <= r; i++) {
                swap(a, l, i);
                helper(a, l + 1, r, res);
                swap(a, l, i); // backtrack
            }
        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums){

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(nums, 0, nums.length-1, res);
        return res;
    }

    public static void main(String[] args){

        int[] nums = {1, 1, 2};
        List<List<Integer>> res = permuteUnique(nums);
        for(List<Integer> r : res){
            System.out.println(r);
        }

    }
}
