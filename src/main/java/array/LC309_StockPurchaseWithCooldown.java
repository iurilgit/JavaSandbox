package array;

/**
 * Created by ruili1 on 1/2/18.
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 Example:

 prices = [1, 2, 3, 0, 2]
 maxProfit = 3
 transactions = [buy, sell, cooldown, buy, sell]

 ---
 solution:

 */
public class LC309_StockPurchaseWithCooldown {

    public static int maxProfit(int[] prices) {

        if(prices.length <= 1){
            return 0;
        }

        int totalGain = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i-1]){
                totalGain += prices[i] - prices[i-1];
                i++;
            }
        }

        return totalGain;
    }

    public static void main(String[] args){

        int[] prices = {1, 2, 3, 0, 2}; //{1, 7, 5, 3, 6, 4}; //{1, 2};{2, 1, 2, 0, 1};
        System.out.println(maxProfit(prices));

    }
}
