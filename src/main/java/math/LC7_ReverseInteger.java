package math;

import array.Interval;

/**
 * Created by ruili1 on 12/30/17.
 */
public class LC7_ReverseInteger {

    public static int reverse(int x) {

        if(x > Integer.MAX_VALUE || x < Integer.MIN_VALUE){
            return 0;
        }

        boolean negative = x < 0;
        if(negative){
            x = -x;
        }

        int rev = 0;
        int q = x;
        while(q > 0){
            int r = q % 10; // remainder
            q = q / 10;     // quotient

            if(rev > Integer.MAX_VALUE/10){
                return 0;
            }
            rev = rev * 10 + r;
        }

        if(negative){
            rev = -rev;
        }

        return rev;
    }

    public static void main(String[] args){

        int x = 1534236469;
        System.out.println(reverse(x));
    }
}
