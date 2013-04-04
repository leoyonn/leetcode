/**
 * Solution.java
 * @author leo
 * @date 2013-3-31
 */
package q02x.q027_strstr;

/**
 * @author leo
 */
public class Solution {
	public static void main(String [] args) {
		Solution s = new Solution();
        System.out.println(s.strStr("aa", "a"));
        System.out.println(s.strStr("aa", "aa"));
        System.out.println(s.strStr("aa", "aaa"));
        System.out.println(s.strStr("aab", "ab"));
        System.out.println(s.strStr("abc", "bc"));
        System.out.println(s.strStr("abc", "d"));
	}

	private int[] makeSunday(char[] p) {
	    int []next = new int[26];
        for (int i = 0; i < 26; i ++) {
            next[i] = p.length + 1;
        }
        for (int i = 0; i < p.length; i ++) {
            next[p[i] - 'a'] = p.length - i;
        }
	    return next;
	}

	public String strStr(String haystack, String needle) {
        if (haystack == null || haystack.length() == 0) {
            if (needle == null || needle.length() == 0) {
                return haystack;
            }
            return null;
        }
        char[] s = haystack.toCharArray(), p = needle.toCharArray();
        int[] next = makeSunday(p);
        for (int i = 0; i <= s.length - p.length; ) {
            int l = p.length - 1;
            while (l >= 0 && s[i + l] == p[l]) {
                l --;
            }
            if (l < 0) {
                return String.valueOf(s, i, s.length - i);
            }
            if (i >= s.length - p.length) {
                break;
            }
            i += next[s[i + p.length] - 'a'];
        }
        return null;
    }
}
