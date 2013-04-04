/**
 * Solution.java
 * @author leo
 * @date 2013-4-3
 */
package q04x.q043_wildchar_matching;

/**
 * <pre>
 *  Wildcard Matching
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
public class Solution_v2 {
    public static void  main(String [] args) {
        Solution_v2 s = new Solution_v2();
        System.out.println(s.isMatch("aa", "*a"));
    }

    public boolean isMatch(String s, String p) {
        // edge cases
        if (s.equals(p) || p.equals("*")) {
            return true;
        } else if (p.length() == 0) {
            return false;
        }
        return match(s.toCharArray(), p.toCharArray());
    }
    
    private boolean match(char[]s, char[]p) {
        int is = 0, ip = 0, bs = 0, bp = 0;
        boolean hasStar = false;
        while (is < s.length) {
            if (ip < p.length && (s[is] == p[ip] || p[ip] == '?')) { // match
                is++;
                ip++;
            } else if (ip < p.length && p[ip] == '*') { // star
                hasStar = true;
                while (ip < p.length && p[ip] == '*') {
                    ip++;
                }
                if (ip == p.length) {
                    return true;
                }
                bs = is;
                bp = ip;
            } else { // no match
                if (!hasStar) {
                    return false;
                }
                is = ++bs;
                ip = bp;
            }
        }
        while(ip < p.length && p[ip] == '*') {
            ip ++;
        }
        return ip == p.length;
    }
}
