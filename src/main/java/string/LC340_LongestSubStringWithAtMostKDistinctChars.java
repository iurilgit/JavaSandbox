package string;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ruili1 on 9/30/17.
 *
 * Given a string, find the length of the longest substring T that contains at most k distinct characters.

 For example, Given s = “eceba” and k = 2,

 T is "ece" which its length is 3.

 ---
 Idea: similar to LC3, keep a <char, count> map
 */
public class LC340_LongestSubStringWithAtMostKDistinctChars {

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {

        Map<Character, Integer> charCountMap = new HashMap<Character, Integer>();

        char[] chars = s.toCharArray();
        int subStringStartIdx = 0;
        int maxLen = 0;
        for(int i = 0; i < chars.length; i++){
            updateMap(charCountMap, chars[i], 1);
            while(charCountMap.size() > k){
                updateMap(charCountMap, chars[subStringStartIdx++], -1);
            }
            if(i - subStringStartIdx + 1 > maxLen){
                maxLen = i - subStringStartIdx + 1;
            }
        }

        return maxLen;
    }

    // when count = 1, increment the occurence in map
    // when count = -1, decrease the occurence in map
    private static void updateMap(Map<Character, Integer> map, char c, int count){

        if(map.containsKey(c)){
            int newCount = map.get(c) + count;
            if(newCount == 0){
                map.remove(c);
            }else{
                map.put(c, newCount);
            }
        }else{
            if(count > 0){
                map.put(c, count);
            }
        }
    }

    public static void main(String[] args){

        String s = "ecebaa";
        System.out.println(lengthOfLongestSubstringKDistinct(s, 1));

    }
}
