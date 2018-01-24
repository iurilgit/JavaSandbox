package array;

/**
 * Created by ruili1 on 1/2/18.
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete at most two transactions.

 Note:
 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

 -----
 solution:
 1 (wrong):
 go through once to find max gain transaction then
 go through rest of the array to find the 2nd max gain transaction.
 if the max gain sells on the last day, return it only.
 the problem is that the 2nd max + 3rd max could beat the max gain.

 2 (correct but too slow):
 cut the array into two subarrays, find the max gain from each, add them up as one best gain.
 iterate through all possible cutting of subarrays, then find the max gain.

 3:

 */
public class LC123_StockPurchaseIII {

    // solution1 (wrong):
    public static int maxProfit1(int[] prices) {

        if(prices.length <= 1){
            return 0;
        }

        // go through once to find the max gain transaction
        int minBuy = prices[0];
        int currGain = 0;
        int maxGain1 = 0;
        int sellDate = 0;
        for(int i = 1; i < prices.length; i++){
            minBuy = Math.min(minBuy, prices[i]); // find the lowest buying price
            currGain = prices[i] - minBuy; // calculate the gain if the it is sold now
            if(currGain > maxGain1) {
                maxGain1 = currGain; // calculate the global max gain
                sellDate = i;
            }
        }
        System.out.println("first max gain: " + maxGain1);
        System.out.println("sell date: " + sellDate);
        if(sellDate == prices.length - 1){
            return maxGain1;
        }

        // go through for the rest of the array to find the 2nd best transaction
        minBuy = prices[sellDate];
        currGain = 0;
        int maxGain2 = 0;
        for(int i = sellDate; i < prices.length; i++){
            minBuy = Math.min(minBuy, prices[i]); // find the lowest buying price
            currGain = prices[i] - minBuy; // calculate the gain if the it is sold now
            if(currGain > maxGain2) {
                maxGain2 = currGain; // calculate the global max gain
            }
        }
        System.out.println(maxGain2);

        return maxGain1 + maxGain2;
    }

    // correct but too slow
    public static int maxProfit2(int[] prices) {

        int maxGain = 0;
        for(int i = 0; i < prices.length; i++){
            int gain1 = oneMaxProfit(prices, 0, i);
            int gain2 = oneMaxProfit(prices, i+1, prices.length-1);
            int gain = gain1 + gain2;
            maxGain = Math.max(maxGain, gain);
        }

        return maxGain;
    }

    // start and end are inclusive
    public static int oneMaxProfit(int[] prices, int start, int end) {

        if(end - start < 1){
            return 0;
        }

        int minBuy = prices[start];
        int currGain = 0;
        int maxGain = 0;
        for(int i = start+1; i <= end; i++){
            minBuy = Math.min(minBuy, prices[i]); // find the lowest buying price
            currGain = prices[i] - minBuy; // calculate the gain if the it is sold now
            if(currGain > maxGain) {
                maxGain = currGain; // calculate the global max gain
            }
        }
        return maxGain;
    }

    // similar idea with 2, but more efficient (using DP)
    // 2 passes:
    // 1st pass from left to right: find the best gain in the subarray from 0 to i
    // 2nd pass from right to left: find the best gain int the subarray from i to len-1
    // then combine the two result arrays (gain1 and gain2) to get the global max gain
    public static int maxProfit3(int[] prices) {

        if(prices.length < 1){
            return 0;
        }

        // first pass from start to end
        int[] gain1 = new int[prices.length];
        int minBuy = prices[0];
        int maxGain1 = 0;
        for(int i = 1; i < prices.length; i++){
            minBuy = Math.min(minBuy, prices[i]); // find the lowest buying price
            int currGain = prices[i] - minBuy; // calculate the gain if it sold now
            maxGain1 = Math.max(maxGain1, currGain); // compare with the maxGain and update it if needed
            gain1[i] = maxGain1;
        }

        // 2nd pass from end to start to find the max gain in the right half
        int[] gain2 = new int[prices.length];
        int maxSell = prices[prices.length-1];
        int maxGain2 = 0;
        for(int i = prices.length-2; i >= 0; i--){
            maxSell = Math.max(maxSell, prices[i]); // find the max selling price
            int currGain = maxSell - prices[i]; // calculate the gain if the it is bought now
            maxGain2 = Math.max(maxGain2, currGain); // compare with the the maxGain and update it if needed
            gain2[i] = maxGain2;
        }

        int maxGain = 0;
        for(int i = 0; i < prices.length; i++){
            int gain = gain1[i] + gain2[i];
            maxGain = Math.max(gain, maxGain);
        }

        return maxGain;
    }

    public static void main(String[] args){

        int[] prices = {1, 2};// {1, 7, 5, 3, 6, 4};// {6,1,3,2,4,7}; // {1, 7, 5, 3, 6, 4};//
        System.out.println(maxProfit3(prices));

    }
}
