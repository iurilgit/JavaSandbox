package dp;

import java.util.ArrayList;
import java.util.List;

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

 This is a non-recursive version, which calculates all values for 1 to amount.

 */
public class LC322_CoinExchange {

    static List<Integer> allCoinChanges = new ArrayList<Integer>();

    //List<Integer> solution = new ArrayList<Integer>();
    public int coinChange(int[] coins, int amount) {

        allCoinChanges.add(0, 0);
        for(int i = 1; i <= amount; i++) {
            int minCoinNum = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i >= coin) {
                    int prevSolution = allCoinChanges.get(i - coin);
                    if (prevSolution >= 0) {
                        int newMin = prevSolution + 1;
                        if (newMin < minCoinNum) {
                            minCoinNum = newMin;
                        }
                    }
                }
            }

            if (minCoinNum == Integer.MAX_VALUE) {
                allCoinChanges.add(i, -1);
            } else {
                allCoinChanges.add(i, minCoinNum);
            }
        }

        return allCoinChanges.get(amount);
    }

    public static void main(String[] args){

        LC322_CoinExchange coinExchange = new LC322_CoinExchange();

//        int[] coins = {186,419,83,408}; // {1, 2, 5};
//        System.out.println(coinExchange.coinChange(coins, 1));
//        System.out.println(coinExchange.coinChange(coins, 2));
//        System.out.println(coinExchange.coinChange(coins, 3));
//        System.out.println(coinExchange.coinChange(coins, 4));
//        System.out.println(coinExchange.coinChange(coins, 5));
//        System.out.println(coinExchange.coinChange(coins, 9));
//        System.out.println(coinExchange.coinChange(coins, 200));

//        int[] coins = {186,419,83,408};
//        System.out.println(coinExchange.coinChange(coins, 6249));

//        int[] coins = {416,157,454,343};
//        System.out.println(coinExchange.coinChange(coins, 1761));

//        int[] coins = {278,274,153,490};
//        System.out.println(coinExchange.coinChange(coins, 8633));

        int[] coins = {24,311,68,43};
        System.out.println(coinExchange.coinChange(coins, 3076));

    }
}
