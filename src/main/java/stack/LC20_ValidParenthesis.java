package stack;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import static java.lang.System.out;
/**
 * Created by ruili1 on 8/20/17.
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class LC20_ValidParenthesis {

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<Character>();
        char[] ch = s.toCharArray();

        for (int i = 0; i < ch.length; i++) {
            if(ch[i] == '{' || ch[i] == '[' || ch[i] == '('){
                stack.push(ch[i]);
            }else if (ch[i] == '}' || ch[i] == ']' || ch[i] == ')'){
                if(stack.isEmpty()){
                    return false;
                }else {
                    char lastChar = stack.pop();
                    switch (ch[i]) {
                        case '}':
                            if (lastChar != '{') {
                                return false;
                            }
                            break;
                        case (']'):
                            if (lastChar != '[') {
                                return false;
                            }
                            break;
                        case (')'):
                            if (lastChar != '(') {
                                return false;
                            }
                            break;
                        default:
                            break;
                    }
                }
            }else{
                // ignore
            }
        }

        return stack.isEmpty();
    }

    // simpler version that only these 6 chars are allowed in the string: {}[]()
    public static boolean isValidSimpler(String s) {

        Stack<Character> stack = new Stack<Character>();
        char[] ch = s.toCharArray();

        for (char c : ch) {
            if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '(') {
                stack.push(')');
            } else {
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        //LinkedList<String> list = new LinkedList<String>();

//        System.out.println(isValid("lirui"));
//        System.out.println(isValid("1[]{c}d(ab)3"));
//        System.out.println(isValid("{{}())"));
//        System.out.println(isValid("{([abc])}"));
//
        System.out.println(isValidSimpler("{([])}"));
        System.out.println(isValidSimpler("{([[])}"));
        System.out.println(isValidSimpler("{}[]()"));
        System.out.println(isValidSimpler("{(}[]()"));
        System.out.println(isValidSimpler("{"));
        System.out.println(isValidSimpler("]"));


    }


}
