package array;

/**
 * Created by ruili1 on 9/17/17.
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.

 If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
 design an algorithm to find the maximum profit.

 Example 1:
 Input: [7, 1, 5, 3, 6, 4]
 Output: 5

 max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
 Example 2:
 Input: [7, 6, 4, 3, 1]
 Output: 0

 In this case, no transaction is done, i.e. max profit = 0.

 ----
 solution:
 DP: at the ith number, keep a variable to hold the minimum purchase price (minBuy)
 so you can calculate the gain if sell now (currGain) and update the minBuy if the current price is lower.
 Use a global variable maxGain to keep track of the max gain (maxGain).

 */
public class LC121_StockPurchase {

    public static int maxProfit(int[] prices) {

        if(prices.length <= 1){
            return 0;
        }

        int minBuy = prices[0];
        int currGain = 0;
        int maxGain = 0;
        for(int i = 1; i < prices.length; i++){
            minBuy = Math.min(minBuy, prices[i]); // find the lowest buying price
            currGain = prices[i] - minBuy; // calculate the gain if the it is sold now
            maxGain = Math.max(maxGain, currGain); // calculate the global max gain
        }

        return maxGain;
    }

    public static void main(String[] args){

        int[] prices = {1, 7, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));

    }
}
