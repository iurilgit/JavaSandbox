package string;

import java.util.Arrays;

/**
 * Created by ruili1 on 9/9/17.
 *
 *
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

 Example:

 Input: "babad"

 Output: "bab"

 Note: "aba" is also a valid answer.
 Example:

 Input: "cbbd"

 Output: "bb"
 */
public class LC5_LongestPalindromicSubstring {


    public static String longestPalindrome(String s) {

        char[] chars = s.toCharArray();
        int len = chars.length;

        if(len <= 1){
            return s;
        }

        String max = String.valueOf(chars[0]);
        for(int i = 0; i < len; i++){
            String maxSubString = extendToEvenLength(chars, i);
            if (maxSubString.length() > max.length()) {
                max = maxSubString;
            }

            maxSubString = extendToOddLength(chars, i);
            if(maxSubString.length() > max.length()){
                max = maxSubString;
            }
        }

        return max;
    }

    private static String extendToEvenLength(char[] chars, int midLeftIdx){

        if(midLeftIdx == chars.length -1){
            return String.valueOf(chars[midLeftIdx]);
        }

        int left = midLeftIdx;
        int right = midLeftIdx + 1;
        while(left >= 0 && right <= chars.length - 1){
            if(chars[left] == chars[right]){
                left--;
                right++;
            }else{
                break;
            }
        }

        return String.valueOf(Arrays.copyOfRange(chars, left + 1, right));
    }

    private static String extendToOddLength(char[] chars, int midIdx){

        if(midIdx == chars.length -1){
            return String.valueOf(chars[midIdx]);
        }

        int left = midIdx - 1;
        int right = midIdx + 1;
        while(left >= 0 && right <= chars.length - 1){
            if(chars[left] == chars[right]){
                left--;
                right++;
            }else{
                break;
            }
        }


        return String.valueOf(Arrays.copyOfRange(chars, left + 1, right));
    }


    public static void main(String[] args){

        String s = "babad";
        System.out.println(longestPalindrome(s));
    }
}
