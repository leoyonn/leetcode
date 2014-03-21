/**
 * Solution.java
 * @author leo
 * @date 2013-3-21
 */
package old.q00x.q003_longest_sub_no_repeat;

/**
 * <pre>
 * Longest Substring Without Repeating Characters 787 / 2551
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	System.out.println(s.lengthOfLongestSubstring("abbccde"));
    }

    public int lengthOfLongestSubstring(String s) {
    	char[] arr = s.toCharArray();
    	int[] counter = new int[26];
    	int maxlen = 0;
    	for (int i = 0, j = 0; i < arr.length; i ++) {
    		int count = ++ counter[arr[i] - 'a'];
    		if (count == 2) { // got a dup, remove it.
    			while (j < i) {
    				counter[arr[j] - 'a'] --;
    				j ++;
    				if (arr[j - 1] == arr[i]) {
    					break;
    				}
    			}
    		}
    		if (maxlen < i - j + 1) {
    			maxlen = i - j + 1;
    		}
    		
    	}
        return maxlen;
    }
}