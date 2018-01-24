package math;

/**
 * Created by ruili1 on 12/30/17.
 *
 Determine whether an integer is a palindrome. Do this without extra space.

 Some hints:
 Could negative integers be palindromes? (ie, -1)

 If you are thinking of converting the integer to string, note the restriction of using extra space.

 You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

 There is a more generic way of solving this problem.

 Solution:
 similar concept as the string palindrom algo, get the left most digit and right most digit.
 If they are not the same, return false.
 If they are the same, remove the left and right most digits and do the same check.

 */
public class LC9_PalindromNumber {

    // reverse the original number to see if it equals to the original number
    public static boolean isPalindrome1(int x) {

        if(x < 0){
            return false;
        }

        int rev = 0;
        int q = x;
        while(q > 0){
            int r = q % 10; // remainder
            q = q / 10;     // quotient

            rev = rev * 10 + r;
        }

        return rev == x;
    }

    // compare the left most and right most digits
    // but it doesn't work for the case where there are a lot of 0s in the middle
    public static boolean isPalindrome2(int x) {

        if(x < 0){
            return false;
        }

        int order = 1;
        while( x / order >= 10){
            order *= 10;
        }

        while(x > 0){

            int l = x/order;
            int r = x % 10;

            if(l != r){
                return false;
            }else{
                x = x%order; // remove l
                x = x/10;    // remove r
//                System.out.println(x);
                order /= 100;
            }
        }

        return true;
    }

    public static void main(String[] args){

        System.out.println(isPalindrome2(1)); // wrong answer

        System.out.println(isPalindrome1(-1)); // false
        System.out.println(isPalindrome2(-1));

        System.out.println(isPalindrome1(0)); // true
        System.out.println(isPalindrome2(0));

        System.out.println(isPalindrome1(121)); // true
        System.out.println(isPalindrome2(121));

        System.out.println(isPalindrome1(122)); // false
        System.out.println(isPalindrome2(122));

        System.out.println(isPalindrome1(1221)); // true
        System.out.println(isPalindrome2(1221));
    }
}
