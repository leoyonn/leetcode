/**
 * Solution.java
 * @author leo
 * @date 2013-3-30
 */
package q020_valid_parentheses;

import java.util.Stack;

/**
 * @author leo
 */
public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        } else if ((s.length() & 1) == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        for (char c: s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char pair = stack.pop();
                if (        pair == '{' && c == '}'
                        ||  pair == '[' && c == ']'
                        ||  pair == '(' && c == ')') {
                    continue;
                }
                return false;
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

}
