package dp;

/**
 * Created by ruili1 on 1/2/18.
 *
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

 For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.

 ----
 solution:
 DP:
 iterate i from 1 to n, if i is a perfect square, return 1.
 Otherwise, try to break i into a + b, and look up dp[a] + dp[b] and minimize it for all combination of a and b.
 */
public class LC279_PerfectSquares {

    public static int numSquares(int n) {

        if(n == 0){
            return 1;
        }

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            if(isSquare(i)){
                dp[i] = 1;
            }else{
                int min = Integer.MAX_VALUE;
                for(int j = 1; j <= i/2; j++){
                    int way = dp[j] + dp[i-j];
                    min = Math.min(min, way);
                }
                dp[i] = min;
            }
        }
        return dp[n];
    }

    private static boolean isSquare(int n){

        if(n == 1){
            return true;
        }

        for(int i = 1; i <= n/2; i++){
            int square = i*i;
            if(square == n){
                return true;
            }else if(square > n){
                break;
            }
        }
        return false;
    }

    public static void main(String[] args){

        System.out.println(numSquares(0));
        System.out.println(numSquares(1));
        System.out.println(numSquares(3));
        System.out.println(numSquares(4));
        System.out.println(numSquares(6));
    }
}
