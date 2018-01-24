package string;

import java.util.*;

/**
 * Created by ruili1 on 9/30/17.
 *
 * Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits.
 * There is no limit on how many times a digit can be reused.

 You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid.
 "1:34", "12:9" are all invalid.

 Example 1:

 Input: "19:34"
 Output: "19:39"
 Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later.
 It is not 19:33, because this occurs 23 hours and 59 minutes later.
 Example 2:

 Input: "23:59"
 Output: "22:22"
 Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22.
 It may be assumed that the returned time is next day's time since it is smaller than the input time numerically.

 */
public class LC681_NextClosestTime {

    public static String nextClosestTime(String time) {

        String[] fields = time.split(":");
        Integer hr = Integer.parseInt(fields[0]);
        Integer min = Integer.parseInt(fields[1]);

        // put all chars into a sorted list (ascending)
        Set<Integer> digits = new HashSet<Integer>();
        for(char c : fields[0].toCharArray()){
            digits.add(Character.getNumericValue(c));
        }
        for(char c : fields[1].toCharArray()){
            digits.add(Character.getNumericValue(c));
        }
        List<Integer> digitsSorted = new ArrayList<Integer>(digits);
        Collections.sort(digitsSorted);

        Integer newMin = getNextTime(min, 60, digitsSorted);
        if(newMin > min){
            return String.format("%02d", hr) + ":" + String.format("%02d", newMin);
        }

        Integer newHr = getNextTime(hr, 24, digitsSorted);
        if(newHr >= 0){
            return String.format("%02d", newHr) + ":" + String.format("%02d", newMin);
        }else{
            return null;
        }
    }

    private static Integer getNextTime(int time, int upperLimit, List<Integer> digits){

        int upperDigit = time / 10;
        int lowerDigit = time % 10;

        // there is a digit larger than lower digit
        for(Integer i : digits){
            if(i > lowerDigit && upperDigit*10 + i < upperLimit){
                return upperDigit*10 + i;
            }
        }

        // there is a digit larger than upper digit
        for(Integer i : digits){
            if(i > upperDigit){
                // find the smallest digit for lower digit
                for(Integer j : digits){
                    if(j < lowerDigit && i*10 + j < upperLimit){
                        return i*10 + j;
                    }
                }
            }
        }

        int newTime = digits.get(0)*10 + digits.get(0);
        if(newTime <= upperLimit){
            return newTime;
        }else{
            return -1;
        }
    }

    public static void main(String[] args){

        String s = "1:32" ; //"9:8";//""19:34"; //"01:34";
        System.out.println(nextClosestTime(s));

    }
}
