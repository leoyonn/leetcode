/**
 * Solution.java
 * @author leo
 * @date 2013-4-3
 */
package q04x.q043_wildchar_matching;




/**
 * <pre>
 *  Wildcard MatchingMar 16 '12
 * Implement wildcard pattern matching with support for '?' and '*'.
 * 
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * 
 * Some examples:
 * isMatch("aa","a") ? false
 * isMatch("aa","aa") ? true
 * isMatch("aaa","aa") ? false
 * isMatch("aa", "*") ? true
 * isMatch("aa", "a*") ? true
 * isMatch("ab", "?*") ? true
 * isMatch("aab", "c*a*b") ? false
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    public static void  main(String [] args) {
        Solution s = new Solution();
        System.out.println(s.isMatch("abaaa", "*ba?*"));
    }

    public boolean isMatch(String s, String p) {
        // edge cases
        if (s.equals(p) || p.equals("*")) {
            return true;
        } else if (p.length() == 0) {
            return false;
        }
        s = "a" + s + "a"; p = "a" + p + "a";
        return match(s.toCharArray(), p.split("\\*"));
    }
    
    private boolean match(char[]s, String[]pats) {
        // match head
        char[] p = pats[0].toCharArray();
        if (s.length < p.length) {
            return false;
        }
        int i;
        for (i = 0; i < p.length; i ++) {
            if (s[i] != p[i] && p[i] != '?' && s[i] != '?') {
                return false;
            }
        }
        // match tail
        if (pats.length == 1) {
            return s.length == i;
        }
        p = pats[pats.length - 1].toCharArray();
        int si = s.length - p.length;
        if (si < i) {
            return false;
        }
        for (i = 0; i < p.length; i ++) {
            if (s[si + i] != p[i] && p[i] != '?' && s[si + i] != '?') {
                return false;
            }
        }
        if (pats.length == 2) {
            return true;
        }
        // match middle
        int start = pats[0].length(), end = s.length - p.length;
        for (int pi = 1; pi < pats.length - 1; pi ++) {
            p = pats[pi].toCharArray();
            start = find(s, p, start) + p.length;
            if (start < p.length || start > end) {
                return false;
            }
        }
        return true;
    }
    
    private int find(char[] s, char[] p, int start) {
        int[] next = makeSunday(p);
        for (int i = start; i <= s.length - p.length; ) {
            int l = p.length - 1;
            while (l >= 0 && (s[i + l] == p[l] || p[l] == '?' || s[i + l] == '?')) {
                l --;
            }
            if (l < 0) {
                return i;
            }
            if (i >= s.length - p.length) {
                break;
            }
            i += next[s[i + p.length] - 'a'];
        }
        return -1;
    }

    private int[] makeSunday(char[] p) {
        int []next = new int[26];
        for (int i = 0; i < 26; i ++) {
            next[i] = p.length + 1;
        }
        // should notice that '?' can be anything, so update each alpha's next.
        int lastq = 0;
        for (int i = 0; i < p.length; i ++) {
            if (p[i] == '?') {
                lastq = i;
            } else {
                next[p[i] - 'a'] = p.length - i;
            }
        }
        for (int i = 0; i < 26; i ++) {
            if (next[i] > p.length - lastq) {
                next[i] = p.length - lastq;
            }
        }
        return next;
    }
}
