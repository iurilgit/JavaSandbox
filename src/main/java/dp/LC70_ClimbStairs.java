package dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ruili1 on 8/30/17.
 * You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 Note: Given n will be a positive integer.

 */
public class LC70_ClimbStairs {

    static List<Integer> ways = new ArrayList<Integer>();

    public static int climbStairs(int n) {

        for(int i = 0; i <= n; i++){
            if(i == 0){
                ways.add(i, 0);
            }else if(i == 1){
                ways.add(i, 1);
            }else if( i == 2) {
                ways.add(i, 2);
            }else{
                ways.add(i, ways.get(i-1) + ways.get(i-2));
            }
        }

        return ways.get(n);
    }

    public static void main(String[] args){

        LC70_ClimbStairs climbStairs = new LC70_ClimbStairs();
        System.out.println(climbStairs.climbStairs(1));
        System.out.println(climbStairs.climbStairs(2));
        System.out.println(climbStairs.climbStairs(3));
        System.out.println(climbStairs.climbStairs(5));
    }
}
