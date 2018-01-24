package string;

import java.util.Stack;

/**
 * Created by ruili1 on 9/30/17.
 *
 * we abstract our file system by a string in the following manner:

 The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:

 dir
    subdir1
    subdir2
        file.ext
 The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.

 The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:

 dir
    subdir1
        file1.ext
        subsubdir1
    subdir2
        subsubdir2
            file2.ext

 The directory dir contains two sub-directories subdir1 and subdir2.
 subdir1 contains a file file1.ext and an empty second-level sub-directory subsubdir1.
 subdir2 contains a second-level sub-directory subsubdir2 containing a file file2.ext.

 We are interested in finding the longest (number of characters) absolute path to a file within our file system.
 For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext",
 and its length is 32 (not including the double quotes).

 Given a string representing the file system in the above format, return the length of the longest absolute path
 to file in the abstracted file system. If there is no file in the system, return 0.

 Note:
 The name of a file contains at least a . and an extension.
 The name of a directory or sub-directory will not contain a ..
 Time complexity required: O(n) where n is the size of the input string.

 Notice that a/aa/aaa/file1.txt is not the longest file path, if there is another path aaaaaaaaaaaaaaaaaaaaa/sth.png.

 ----
 Idea:

 Split the string by "\n" to get name of each dir or file.
 Based on the number of leading "\t", we can tell the level of the dir or file.
 Use a stack to push the dir or file to construct an abs path and track the length.
 The size of the stack is the number of levels in the current abs path.
 If a new dir has a level number lower than stack size, pop some out and adjust the curr len.
 Only update the maxLen if the curr dir is a file.

 */
public class LC388_LongestAbsFilePath {

    public static int lengthLongestPath(String input) {

        if(input.length() == 0){
            return 0;
        }

        Stack<String> stack = new Stack<String>();
        String[] dirs = input.split("\n");

        int maxLen = 0;
        int len = 0;
        for (String dir : dirs) {
            int level = getFileLevel(dir);
            while (stack.size() > level) {
                len -= stack.pop().length();
            }
            dir = dir.substring(level);
            if(level != 0){
                dir = "\\" + dir;
            }
            stack.push(dir);
            len += dir.length();
            if(len > maxLen && isFile(dir)){
                maxLen = len;
            }
        }

        return maxLen;
    }

    // get the number of leading tabs in a string to decide its directory level
    private static int getFileLevel(String s){

        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++){
            if(chars[i] != '\t'){
                return i;
            }
        }

        return chars.length;
    }

    private static boolean isFile(String s){

        return s.contains(".");
    }

    public static void main(String[] args){

        String s1 = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        String s2 = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";

        System.out.println(lengthLongestPath(s1));
        System.out.println(lengthLongestPath(s2));
    }
}
