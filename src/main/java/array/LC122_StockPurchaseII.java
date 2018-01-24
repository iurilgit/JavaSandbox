package array;

/**
 * Created by ruili1 on 9/17/17.
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 (ie, buy one and sell one share of the stock multiple times). However,
 you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

 ---
 solution2:
 very simple: if the current price is higher than yesterday, just calculate the gain and accumulate to total gain.

 */
public class LC122_StockPurchaseII {

    // variation from LC121, but not good
    public static int maxProfit(int[] prices) {

        if(prices.length <= 1){
            return 0;
        }

        int minBuy = prices[0];
        int currGain = 0;
        int maxGain = 0;
        for(int i = 1; i < prices.length; i++){
            minBuy = Math.min(minBuy, prices[i]); // find the lowest buying price
            if(prices[i] > prices[i-1]){    // hold
                currGain = prices[i] - minBuy; // calculate the gain if the it is sold now
            }else{  // sell yesterday and buy today
                maxGain += currGain;
                minBuy = prices[i];
                currGain = 0;
            }
        }

        return maxGain + currGain;
    }

    // simpler
    public static int maxProfit2(int[] prices) {

        if(prices.length <= 1){
            return 0;
        }

        int totalGain = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i-1]){
                totalGain += prices[i] - prices[i-1];
            }
        }

        return totalGain;
    }

    public static void main(String[] args){

        int[] prices = {1, 2};//{2, 1, 2, 0, 1}; // {1, 7, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfit2(prices));

    }
}
