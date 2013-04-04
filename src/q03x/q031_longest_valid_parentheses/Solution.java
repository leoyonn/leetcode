/**
 * Solution.java
 * @author leo
 * @date 2013-4-1
 */
package q031_longest_valid_parentheses;

import java.util.Stack;


/**
 * <pre>
 * <b>Longest Valid Parentheses</b>
 * Given a string containing just the characters '(' and ')', find the length of the longest valid
 *  (well-formed) parentheses substring.
 * 
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * 
 * Another example is ")()())", where the longest valid parentheses substring is "()()",
 *  which has length = 4.
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestValidParentheses("()()"));
        System.out.println(s.longestValidParentheses("(())"));
        System.out.println(s.longestValidParentheses("(()))"));
        System.out.println(s.longestValidParentheses("()(()"));
    }

    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        } else if (s.equals("()")) {
            return 2;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0, lc = 0;
        for (char c:s.toCharArray()) {
            // '(': push 0 into stack
            if (c == '(') {
                stack.push(0);
                lc ++;
                continue;
            }
            // ')' > '(': reset
            if (stack.empty() || lc == 0) {
                stack.clear();
                continue;
            }
            // find the nearest '(' to combine with this ')', and union whatever inside.
            int v = stack.pop();
            --lc;
            if (v != 0) {
                stack.pop();
                ++v;
            } else {
                v = 1;
            }
            // union
            if (!stack.empty() && stack.peek() != 0) {
                v += stack.pop();
            }
            stack.push(v);
            if (v > max) {
                max = v;
            }
        }
        return max * 2;
    }
}
