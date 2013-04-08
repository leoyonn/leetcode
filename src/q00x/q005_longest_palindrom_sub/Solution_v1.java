/**
 * Solution.java
 * @author leo
 * @date 2013-3-21
 */
package q00x.q005_longest_palindrom_sub;

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
public class Solution_v1 {
	public static void main(String [] args) {
		Solution_v1 s = new Solution_v1();
		System.out.println(s.longestPalindrome("1"));
		System.out.println(s.longestPalindrome("11"));
		System.out.println(s.longestPalindrome("121"));
		System.out.println(s.longestPalindrome("1212"));
		System.out.println(s.longestPalindrome("12121"));
		System.out.println(s.longestPalindrome("12123"));
		System.out.println(s.longestPalindrome("112212"));
		System.out.println(s.longestPalindrome("121234543"));
	}
	
	public String longestPalindrome(String s) {
    	if (s == null || s.length() < 2) {
    		return s;
    	}
    	char[] arr = s.toCharArray();
    	int max = 1, maxi = 0;
    	// odd palidrome
    	for (int i = 1; i < arr.length - 1; i ++) {
    		int j = 1;
    		while (j <= Math.min(i, arr.length - 1 - i) && arr[i + j] == arr[i - j]) {
    			j ++;
    		}
    		j --;
    		if (j * 2 + 1 > max) {
    			max = j * 2 + 1;
    			maxi = i;
    		}
    	}
    	//even palindrome
    	for (int i = 1; i < arr.length; i ++) {
    		int j = 0;
    		while (j <= Math.min(i - 1, arr.length - 1 - i) && arr[i + j] == arr[i - 1 - j]) {
    			j ++;
    		}
    		if (j * 2 > max) {
    			max = j * 2;
    			maxi = i;
    		}
    	}
		return s.substring(maxi - max / 2, maxi + (max + 1) / 2);
    }

}