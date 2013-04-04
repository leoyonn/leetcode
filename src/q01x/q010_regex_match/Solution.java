package q010_regex_match;


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