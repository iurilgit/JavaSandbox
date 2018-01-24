package string;

/**
 * Created by ruili1 on 9/30/17.
 *
 * Now you are given a string S, which represents a software license key which we would like to format.
 * The string S is composed of alphanumerical characters and dashes. The dashes split the alphanumerical
 * characters within the string into groups. (i.e. if there are M dashes, the string is split into M+1 groups).
 * The dashes in the given string are possibly misplaced.

 We want each group of characters to be of length K (except for possibly the first group, which could be shorter,
 but still must contain at least one character). To satisfy this requirement, we will reinsert dashes.
 Additionally, all the lower case letters in the string must be converted to upper case.

 So, you are given a non-empty string S, representing a license key to format, and an integer K.
 And you need to return the license key formatted according to the description above.

 Example 1:
 Input: S = "2-4A0r7-4k", K = 4

 Output: "24A0-R74K"

 Explanation: The string S has been split into two parts, each part has 4 characters.
 Example 2:
 Input: S = "2-4A0r7-4k", K = 3

 Output: "24-A0R-74K"

 Explanation: The string S has been split into three parts, each part has 3 characters
 except the first part as it could be shorter as said above.
 Note:
 The length of string S will not exceed 12,000, and K is a positive integer.
 String S consists only of alphanumerical characters (a-z and/or A-Z and/or 0-9) and dashes(-).
 String S is non-empty.

 --
 Idea 1:
 Conert the string to upper case and remove all dashes (by splitting it with dash)
 Then scan it from end to start and insert dashes accordingly.

 Idea 2:

 Scan string from end to start.
 If the current char is a dash, skip, else insert it to head of a StringBuilder.
 If the scanned chars are multiple of k, insert it to head of the StringBuilder
 Convert the StringBuilder to string then upper case it to return.

 */
public class LC482_LicenseKeyFormatting {

    public static String licenseKeyFormatting(String s, int k) {

        s = s.toUpperCase();
        String[] segments = s.split("-");
        StringBuilder sb = new StringBuilder();
        for(String segment : segments){
            sb.append(segment);
        }

        StringBuilder newSb = new StringBuilder();
        for(int i = sb.length() - 1; i >= 0; i--){
            newSb.insert(0, sb.charAt(i));
            if((sb.length() - i) % k == 0 && i != 0){
                newSb.insert(0, "-");
            }
        }

        return newSb.toString();
    }

    // no extra space is used
    public static String licenseKeyFormatting2(String s, int k) {

        StringBuilder sb = new StringBuilder();
        int charNum = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            char c = s.charAt(i);
            if(c != '-') {
                sb.insert(0, c);
                charNum ++;

                if(charNum % k == 0 && i != 0){
                    sb.insert(0, "-");
                }
            }
        }

        if(sb.length() > 0 && sb.charAt(0) == '-'){
            return sb.substring(1).toUpperCase();
        }else {
            return sb.toString().toUpperCase();
        }
    }

    public static void main(String[] args){

//        String s = "2-4A0r7-4k";
        String s = "---";
        System.out.println(licenseKeyFormatting2(s, 3));
    }
}
