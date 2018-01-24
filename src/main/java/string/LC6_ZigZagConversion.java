package string;

/**
 * Created by ruili1 on 9/6/17.
 */
public class LC6_ZigZagConversion {

    public static String convert(String s, int numRows) {

        if(numRows == 1){
            return s;
        }

        char[] chars = s.toCharArray();
        int len = chars.length;

        char[] newChars = new char[len];
        int j = 0; // idx for newChars
        for(int i = 0; i < numRows; i++){
            int k = 0;
            while(true) {
                int idx;
                if(i > 0 && i < numRows -1){
                    idx = k * (2 * numRows - 2) - i;
                    if(idx >= 0 && idx < len){
                        newChars[j++] = chars[idx];
                    }
                }
                idx = k * (2 * numRows - 2) + i;
                if(idx >= 0 && idx < len && j < len){
                    newChars[j++] = chars[idx];
                }
                if(idx >= len || j >= len){
                    break;
                }
                k++;
            }
        }

        return String.valueOf(newChars);
    }

    public static void main(String[] args){

        String s1 = "AB"; // "PAYPALISHIRING"; // "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String s2 = convert(s1, 1);
        System.out.println(s2);
    }
}
