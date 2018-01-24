package string;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ruili1 on 9/7/17.
 *
 * Given a roman numeral, convert it to an integer.

 Input is guaranteed to be within the range from 1 to 3999.
 */
public class LC13_RomanToArabicConverter {

    public static int romanToInt(String s) {

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char[] chars = s.toCharArray();
        int len = chars.length;
        int idx1 = 0;
        int idx2 = 1;
        int val1, val2;
        int num = 0;
        while(idx2 < len){
            val1 = map.get(chars[idx1]);
            val2 = map.get(chars[idx2]);
            if(val1 < val2){
                num += val2 - val1;
                idx1 += 2;
                idx2 += 2;
            }else{
                num += val1;
                idx1 += 1;
                idx2 += 1;
            }
        }

        if(idx1 < len){
            num += map.get(chars[idx1]);
        }

        return num;
    }

    public static void main(String[] args){

        String s = "XCIX";
        System.out.println(romanToInt(s));
    }
}
