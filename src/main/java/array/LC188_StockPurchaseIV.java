package array;

/**
 * Created by ruili1 on 1/2/18.
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete at most k transactions.

 Note:
 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

---
 solution:
 DP to keep a result in a matrix[K][len]

 */
public class LC188_StockPurchaseIV {

    // correct, but too slow, O(N*N)
    public static int maxProfit(int K, int[] prices) {

        int len = prices.length;

        if(K <= 0 || len <=1){
            return 0;
        }

        int[][] maxProfits = new int[K+1][len];
        for(int i = 0; i < len; i++){
            maxProfits[0][i] = 0;
        }

        for(int k = 1; k <= K; k++){
            maxProfits[k][0] = 0;
            int maxDiff = maxProfits[k][0] - prices[0];
            for(int i = 1; i <len; i++){
                int tempMax = Integer.MIN_VALUE;
                for(int m = 0; m < i; m++){
                    tempMax = Math.max(tempMax, maxProfits[k-1][m] - prices[m]);
                }
                maxProfits[k][i] = Math.max(maxProfits[k][i-1], tempMax + prices[i]);
            }
        }

        return maxProfits[K][len-1];
    }

    // correct, faster O(N), but use too much memory O(KN)
    public static int maxProfit2(int K, int[] prices) {

        int len = prices.length;

        if(K <= 0 || len <=1){
            return 0;
        }

        int[][] maxProfits = new int[K+1][len];
        for(int i = 0; i < len; i++){
            maxProfits[0][i] = 0;
        }

        for(int k = 1; k <= K; k++){
            maxProfits[k][0] = 0;
            int maxDiff = maxProfits[k-1][0] - prices[0];
            for(int i = 1; i <len; i++){
                maxDiff = Math.max(maxDiff, maxProfits[k-1][i] - prices[i]);
                maxProfits[k][i] = Math.max(maxProfits[k][i-1], maxDiff + prices[i]);
            }
        }

        return maxProfits[K][len-1];
    }

    // best solution, fast and use O(N) memory
    public static int maxProfit3(int K, int[] prices) {

        int len = prices.length;

        if(K > len/2){
            return quickSolve(prices);
        }

        if(K <= 0 || len <=1){
            return 0;
        }

        int[] prevMaxProfits = new int[len];
        int[] currMaxProfits = new int[len];
        for(int k = 1; k <= K; k++){
            currMaxProfits[0] = 0;
            int maxDiff = prevMaxProfits[0] - prices[0];
            for(int i = 1; i <len; i++){
                maxDiff = Math.max(maxDiff, prevMaxProfits[i] - prices[i]);
                currMaxProfits[i] = Math.max(currMaxProfits[i-1], maxDiff + prices[i]);
            }
            for(int i = 0; i < len; i++){
                prevMaxProfits[i] = currMaxProfits[i];
            }
        }

        return currMaxProfits[len-1];
    }

    private static int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {2, 5, 7, 1, 4, 3, 1, 3}; //{1, 7, 5, 3, 6, 4};
        System.out.println(maxProfit(2, prices));
        System.out.println(maxProfit2(2, prices));
        System.out.println(maxProfit3(2, prices));
    }
}
