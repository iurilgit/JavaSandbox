package dp;

/**
 * Created by ruili1 on 8/30/17.
 *
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

 Example 1:
 coins = [1, 2, 5], amount = 11
 return 3 (11 = 5 + 5 + 1)

 Example 2:
 coins = [2], amount = 3
 return -1.

 Note:
 You may assume that you have an infinite number of each kind of coin.

This is a recursive version, which will be super slow when amount is large.

 */
public class LC322_CoinExchangeRecursive {

    public static int coinChange(int[] coins, int amount) {

        if(amount == 0){
            return 0;
        }

        int minCoinNum = Integer.MAX_VALUE;
        for(int coin : coins){
            if(amount >= coin) {
                int prevSolution = coinChange(coins, amount - coin);
                if(prevSolution >= 0) {
                    int newMin = prevSolution + 1;
                    if (newMin < minCoinNum) {
                        minCoinNum = newMin;
                    }
                }
            }
        }

        if (minCoinNum == Integer.MAX_VALUE) {
            return -1;
        } else {
            return minCoinNum;
        }
    }

    public static void main(String[] args){
        int[] coins = {1, 2, 5};
        System.out.println(coinChange(coins, 20));
    }
}
