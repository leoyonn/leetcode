/**
 * Solution.java
 * @author leo
 * @date 2013-3-30
 */
package q02x.q020_valid_parentheses;


/**
 * <pre>
 * Valid Parentheses 539 / 1387
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid 
 * but "(]" and "([)]" are not.
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        } else if ((s.length() & 1) == 1) {
            return false;
        }
        char[] arr = s.toCharArray();
        int i = -1, j = 0;
        for (; j < arr.length; j ++) {
            char c = arr[j];
            if (c == '{' || c == '[' || c == '(') {
                arr[++i] = c;
            } else {
                if (i <= 0) {
                    return false;
                }
                char pair = arr[i --];
                if (        pair == '{' && c == '}'
                        ||  pair == '[' && c == ']'
                        ||  pair == '(' && c == ')') {
                    continue;
                }
                return false;
            }
        }
        if (i >= 0) {
            return false;
        }
        return true;
    }
}
