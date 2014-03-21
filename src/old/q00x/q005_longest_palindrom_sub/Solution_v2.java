/**
 * Solution.java
 * @author leo
 * @date 2013-3-21
 */
package old.q00x.q005_longest_palindrom_sub;

/**
 * <pre>
 * Longest Palindromic Substring 723 / 2394
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, 
 * and there exists one unique longest palindromic substring.
 * </pre>
 * 
 * @author leo
 */
public class Solution_v2 {
	public static void main(String [] args) {
		Solution_v2 s = new Solution_v2();
		System.out.println(s.longestPalindrome("1"));
		System.out.println(s.longestPalindrome("11"));
		System.out.println(s.longestPalindrome("121"));
		System.out.println(s.longestPalindrome("1212"));
		System.out.println(s.longestPalindrome("12121"));
		System.out.println(s.longestPalindrome("12123"));
		System.out.println(s.longestPalindrome("112212"));
		System.out.println(s.longestPalindrome("121234543"));
	}

	/**
	 * v2: manecher method
	 * @param s
	 * @return
	 */
	public String longestPalindrome(String s) {
    	if (s == null || s.length() < 2) {
    		return s;
    	}
    	// pre-process to ignore odd/even
    	StringBuilder sb = new StringBuilder();
    	sb.append("^#");
    	for (int i = 0; i < s.length(); i ++) {
    		sb.append(s.charAt(i)).append('#');
    	}
    	sb.append('$');
    	// process using history
    	char[] arr = sb.toString().toCharArray();
    	int mid = 0, max = 0;
    	int[] p = new int[arr.length];
    	for (int i = 1; i < arr.length; i ++) {
    		int i_ = 2 * mid - i; // mirror of i
    		if (i_ >= 0 && p[i_] > 0) {
    			p[i] = Math.min(p[i_], max - i);
    		}
    		while (i + p[i] < arr.length && arr[i + p[i]] == arr[i - p[i]]) {
    			p[i] ++;
    		}
    		if (i + p[i] > max) {
    			mid = i;
    			max = mid + p[mid];
    		}
    	}
    	// find max
    	int maxi = 0;
    	for (int i = 1; i < arr.length; i ++) {
    		if (p[i] > p[maxi]) {
    			maxi = i;
    		}
    	}
    	return new String(arr).substring(maxi - p[maxi] + 1, maxi + p[maxi]).replaceAll("#", "");
	}
}