/**
 * Solution.java
 * @author leo
 * @date 2013-3-21
 */
package old.q01x.q010_regex_match;

/**
 * <pre>
 * Regular Expression Matching 519 / 1857
 * Implement regular expression matching with support for '.' and '*'.
 * 
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
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
 * isMatch("aa", "a*") ? true
 * isMatch("aa", ".*") ? true
 * isMatch("ab", ".*") ? true
 * isMatch("aab", "c*a*b") ? true
 * </pre>
 * 
 * @author leo
 */
public class Solution {
	public static void main(String [] args) {
		Solution s = new Solution();
		System.out.println(s.isMatch("", ""));
		System.out.println(s.isMatch("aa", "a"));
		System.out.println(s.isMatch("aa", ".*"));
		System.out.println(s.isMatch("aaa", "ab*a"));
		System.out.println(s.isMatch("ab", ".*c"));
	}
    public boolean isMatch(String s, String p) {
    	if (s.length() == 0 && p.length() == 0 || p.equals(".*")) {
    		return true;
    	}
    	return match(s.toCharArray(), p.toCharArray(), 0, 0);
    }
    
    public boolean match(char[] s, char[] p, int si, int pi) {
    	if (pi == p.length) {
    		return si == s.length;
    	}
    	if (pi == p.length - 1 || p[pi + 1] != '*') {
    		if (si < s.length && (s[si] == p[pi] || p[pi] == '.')) {
    			return match(s, p, si + 1, pi + 1);
    		}
			return false;
    	}
    	// pi + 1: *
    	while (si < s.length && (s[si] == p[pi] || p[pi] == '.')) {
    		if (match(s, p, si, pi + 2)) {
    			return true;
    		}
    		si ++;
    	}
    	return match(s, p, si, pi + 2);
    }
}