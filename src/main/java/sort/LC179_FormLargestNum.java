package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ruili1 on 8/23/17.
 *
 Given a list of non negative integers, arrange them such that they form the largest number.
 For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 Note: The result may be very large, so you need to return a string instead of an integer.
 *
 */
public class LC179_FormLargestNum {

    static class StringComparator implements Comparator<String> {
        public int compare(String a, String b){
            Long ab = Long.parseLong(a + b);
            Long ba = Long.parseLong(b + a);
            return ba.compareTo(ab);
        }
    }

    public static String largestNumber(int[] nums){

        // convert the integer array to string list
        List<String> numStrings = new ArrayList<String>();
        for(int num : nums){
            numStrings.add(Integer.toString(num));
        }

        // sort the string list
        Collections.sort(numStrings, new StringComparator());

        // concatenate the string list
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numStrings.size() - 1; i++){
            String str = numStrings.get(i);
            if(!str.equals("0"))
            sb.append(str);
        }
        sb.append(numStrings.get(numStrings.size() - 1));

        return sb.toString();
    }

    public static void main(String[] args){

        int[] nums = {2,1};
//        int[] nums = {3, 30, 34, 5, 9};

        String s = largestNumber(nums);

        System.out.println(s);

    }
}
