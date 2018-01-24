package binarysearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ruili1 on 10/1/17.
 *
 * Nearly every one have used the Multiplication Table. But could you find out the k-th smallest number
 * quickly from the multiplication table?

 Given the height m and the length n of a m * n Multiplication Table, and a positive integer k,
 you need to return the k-th smallest number in this table.

 Example 1:
 Input: m = 3, n = 3, k = 5
 Output:
 Explanation:
 The Multiplication Table:
 1	2	3
 2	4	6
 3	6	9

 The 5-th smallest number is 3 (1, 2, 2, 3, 3).
 Example 2:
 Input: m = 2, n = 3, k = 6
 Output:
 Explanation:
 The Multiplication Table:
 1	2	3
 2	4	6

 The 6-th smallest number is 6 (1, 2, 2, 3, 4, 6).
 Note:
 The m and n will be in the range [1, 30000].
 The k will be in the range [1, m * n]

 ----
 solution:
 binary search between 1 and m*n.
 For each mid in the binary search, call a function (count) to count how many pairs
 gives multiplication less than it.


 */
public class LC668_KthSmallestNumInMultiplicationTable {

    public static int findKthNumberBruteForce(int m, int n, int k) {

        List<Integer> all = new ArrayList<Integer>();
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                all.add(i*j);
            }
        }
        Collections.sort(all);
        return all.get(k-1);

    }

    // binary searchRange (faster way)
    public static int findKthNumber(int m, int n, int k) {

        int low = 1;
        int high = m*n;

        while(low < high){
            int mid = low + (high - low)/2;
            int count = count(mid, m, n);
            if(count >= k){
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    // count how many numbers are smaller than k
    private static int count(int k, int m, int n){

        int count = 0;
        for(int i = 1; i <= m; i++){
            int currCount = Math.min(k/i, n);
            count += currCount;
        }

        return count;
    }


    public static void main(String[] args){

        System.out.println(findKthNumberBruteForce(3, 3, 5));
        System.out.println(findKthNumberBruteForce(2, 3, 6));
        System.out.println(findKthNumber(42, 34, 401));
    }

}
