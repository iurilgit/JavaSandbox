package array;

/**
 * Created by ruili1 on 9/15/17.
 *
 * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

 You may assume the integer do not contain any leading zero, except the number 0 itself.

 The digits are stored such that the most significant digit is at the head of the list.

 */
public class LC66_PlusOne {

    public static  int[] plusOne(int[] digits) {

        int len = digits.length;
        int carry = 1;
        for(int i = len - 1; i >= 0; i--){
            if(digits[i] + carry == 10){
                digits[i] = 0;
                carry = 1;
            }else{
                digits[i] ++;
                return digits;
            }
        }

        digits = new int[len+1];
        digits[0] = 1;

        return digits;

    }

    public static void main(String[] args){

        int[] digits = {9, 9};
        int[] newDigits = plusOne(digits);
        for(int digit : newDigits) {
            System.out.print(digit);
        }
    }
}
