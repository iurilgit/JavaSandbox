package string;

/**
 * Created by ruili1 on 9/7/17.
 *
 * Given an input string, reverse the string word by word.

 For example,
 Given s = "the sky is blue",
 return "blue is sky the".

 Update (2015-02-12):
 For C programmers: Try to solve it in-place in O(1) space.
 */
public class LC151_ReverseWordsInString {

    public static String reverseWords(String s) {

        String[] words = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i = words.length - 1; i >= 0; i--){
            sb.append(words[i]);
            sb.append(" ");
        }

        return sb.toString().trim();
    }


    public static void main(String[] args){

        String s = "I  work   at   eBay  ";
        System.out.println(reverseWords(s));
    }
}
