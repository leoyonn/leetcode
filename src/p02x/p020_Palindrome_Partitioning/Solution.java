/**
 * Solution.java
 * @author leo
 * @date 2014-3-13
 */
package p02x.p020_Palindrome_Partitioning;


import java.util.ArrayList;
import java.util.Stack;

/**
 * <pre>
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
 *
 * For example, given s = "aab",
 * Return
 *
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 * </pre>
 *
 * @author leo
 */
public class Solution {
    /**
     * <pre>
     * 20 / 20 test cases passed.
     * Status: Accepted
     * Runtime: 432 ms
     * Submitted: 0 minutes ago
     * </pre>
     *
     * @param s
     * @return
     */
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        if (s == null || s.length() == 0) {
            return result;
        }
        char[] arr = s.toCharArray();
        Stack<String> stack = new Stack<String>();
        partition(arr, stack, 0, result);
        return result;
    }

    private void partition(char[] arr, Stack<String> stack, int start, ArrayList<ArrayList<String>> result) {
        if (start >= arr.length) {
            ArrayList<String> r = new ArrayList<String>(stack);
            result.add(r);
            return;
        }
        for (int i = start; i < arr.length; i++) {
            if (parlindrome(arr, start, i)) {
                stack.push(String.valueOf(arr, start, i + 1 - start));
                partition(arr, stack, i + 1, result);
                stack.pop();
            }
        }
    }

    private boolean parlindrome(char[] arr, int start, int end) {
        while (start < end && arr[start] == arr[end]) {
            start++;
            end--;
        }
        return start >= end;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().partition("aaaba"));
    }
}
 