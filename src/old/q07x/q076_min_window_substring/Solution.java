/**
 * Solution.java
 * @author leo
 * @date 2013-4-5
 */
package old.q07x.q076_min_window_substring;


/**
 * <pre>
 * Minimum Window Substring 323 / 1420
 * Given a string S and a string T, find the minimum window in S
 *  which will contain all the characters in T in complexity O(n).
 * 
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * 
 * Note:
 * If there is no such window in S that covers all characters in T, return the emtpy string "".
 * If there are multiple such windows, you are guaranteed that there will always be only 
 * one unique minimum window in S.
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("bdab", "ab"));
    }

    public String minWindow(String S, String T) {
        if (S.length() < T.length()) {
            return "";
        }
        char[] s = S.toCharArray(), t = T.toCharArray();
        int[] expect = new int[256], got = new int[256];
        int allGot = 0, min = s.length + 1, mini = -1;
        // what we need
        for (char c: t) {
            expect[c] ++;
        }
        for (int i = 0, j = 0; j < s.length;) {
            // j goes ahead, find min window
            for (; j < s.length && allGot < t.length; j ++) {
                char c = s[j];
                if (expect[c] == 0) {
                    continue;
                }
                got[c] ++;
                if (got[c] <= expect[c]) {
                    allGot ++;
                }
            }
            // i goes at tail, close window
            for (; i < j && allGot == t.length; i ++) {
                char c = s[i];
                if (expect[c] == 0) {
                    continue;
                }
                if (got[c] == expect[c]) {
                    int len = j - i;
                    if (min > len) {
                        min = len;
                        mini = i;
                    }
                    allGot --;
                }
                got[c] --;
            }
        }
        return min <= s.length ? String.valueOf(s, mini, min) : "";
    }
}
