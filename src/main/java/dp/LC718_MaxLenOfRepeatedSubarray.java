package dp;

/**
 * Created by ruili1 on 1/7/18.
 *
 *
 * Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.

 Example 1:
 Input:
 A: [1,2,3,2,1]
 B: [3,2,1,4,7]
 Output: 3
 Explanation:
 The repeated subarray with maximum length is [3, 2, 1].
 Note:
 1 <= len(A), len(B) <= 1000
 0 <= A[i], B[i] < 100

 ----
 solution:
 dp[i+1][j+1]: the length of matched substring ending with A[i] and B[j].
 dp[i][j] = dp[i-1][j-1] + A[i] == B[j] ? 1:0

 */
public class LC718_MaxLenOfRepeatedSubarray {

    public static int findLength(int[] A, int[] B) {

        int lenA = A.length;
        int lenB = B.length;

        if(lenA == 0 || lenB == 0){
            return 0;
        }

        int[][] dp = new int[lenA+1][lenB+1];

        int max = 0;
        for(int i = 0; i < lenA; i++){
            for(int j = 0; j < lenB; j++){
                if(A[i] == B[j]) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                    max = Math.max(max, dp[i+1][j+1]);
                }
            }
        }

        return max;
    }

    public static void main(String[] args){

        int[] A = {1,2,3,2,1};
        int[] B = {3,2,1,4,7};

        System.out.println(findLength(A, B));
    }
}
