package q005_longest_palindrom_sub;

public class Solution {
	public static void main(String [] args) {
		Solution s = new Solution();
		System.out.println(s.longestPalindrome_v2("1"));
		System.out.println(s.longestPalindrome_v2("11"));
		System.out.println(s.longestPalindrome_v2("121"));
		System.out.println(s.longestPalindrome_v2("1212"));
		System.out.println(s.longestPalindrome_v2("12121"));
		System.out.println(s.longestPalindrome_v2("12123"));
		System.out.println(s.longestPalindrome_v2("112212"));
		System.out.println(s.longestPalindrome_v2("121234543"));
	}
	/**
	 * v2: manecher method
	 * @param s
	 * @return
	 */
	public String longestPalindrome_v2(String s) {
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

	public String longestPalindrome_v1(String s) {
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