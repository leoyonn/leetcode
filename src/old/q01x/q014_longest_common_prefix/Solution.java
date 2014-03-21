/**
 * Solution.java
 * @author leo
 * @date 2013-3-21
 */
package old.q01x.q014_longest_common_prefix;

/**
 * <pre>
 * Longest Common Prefix 500 / 1487
 * Write a function to find the longest common prefix string amongst an array of strings.
 * </pre>
 * 
 * @author leo
 */
public class Solution {
	public static void main(String [] args) {
		Solution s = new Solution();
		System.out.println(s.longestCommonPrefix(new String[]{"", ""}));
		System.out.println(s.longestCommonPrefix(new String[]{"I", ""}));
		System.out.println(s.longestCommonPrefix(new String[]{"I", "II"}));
	}

	public String longestCommonPrefix(String[] strs) {
    	if (strs == null || strs.length == 0) {
    		return "";
    	} else if (strs.length == 1) {
    		return strs[0];
    	}
    	String common = strs[0];
    	for (int i = 1; i < strs.length; i ++) {
    		if (common.length() == 0 || strs[i].length() == 0) {
    			return "";
    		}
    		int j = 0, len = Math.min(common.length(), strs[i].length());
    		while(j < len && common.charAt(j) == strs[i].charAt(j)) {
    			j ++;
    		}
    		common = common.substring(0, j);
    	}
    	return common;
    }
}
