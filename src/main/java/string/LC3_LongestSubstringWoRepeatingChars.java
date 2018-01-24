package string;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ruili1 on 9/8/17.
 */
public class LC3_LongestSubstringWoRepeatingChars {

    public static int lengthOfLongestSubstring(String s) {

        int maxLen = 0;
        int rightMostIdx = -1;
        Map<Character, Integer> charIdxMap = new HashMap<Character, Integer>();
        char[] chars = s.toCharArray();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(charIdxMap.containsKey(c)){
                rightMostIdx = Math.max(rightMostIdx, charIdxMap.get(c));
            }
            maxLen = Math.max(maxLen, i - rightMostIdx);
            charIdxMap.put(c, i);
        }

        if(s.length() > 0 && maxLen == 0){
            maxLen = s.length();
        }

        return maxLen;
    }

    public static void main(String[] args){

        String s = "aab";
        System.out.println(lengthOfLongestSubstring(s));

        s = "cd";
        System.out.println(lengthOfLongestSubstring(s));

        s = "b";
        System.out.println(lengthOfLongestSubstring(s));

        s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));

        s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));

        s = "abba";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
