package math;

/**
 * Created by ruili1 on 1/2/18.
 *
 Given a positive integer num, write a function which returns True if num is a perfect square else False.

 Note: Do not use any built-in library function such as sqrt.

 Example 1:

 Input: 16
 Returns: True
 Example 2:

 Input: 14
 Returns: False
 *
 -----
 solution:
 1, try and error: try from 1 ~ num/2, if i*i == num, return true. If i*i > num, return false.
 2, since a square number = 1+3+5+7+..., then subtract 1, 3, 5, 7, ... (series of odd number) from num until it becomes none positive.
 If the result is 0, then return true. If the result is negative, return false.
 */
public class LC367_ValidSquareNumber {

    // solution 1
    public static boolean isPerfectSquare(int num) {

        // try and error
        if(num == 1){
            return true;
        }

        for(int i = 1; i <= num/2; i++){
            int square = i*i;
            if(square == num){
                return true;
            }else if(square > num){
                break;
            }
        }
        return false;
    }

    // solution 2
    public static boolean isPerfectSquare2(int num) {

        int i = 1;
        while(num > 0){
            num -= i;
            i += 2;
        }
        return num == 0;
    }

    public static void main(String[] args){

        System.out.println(isPerfectSquare(3));
        System.out.println(isPerfectSquare(4));
    }
}
