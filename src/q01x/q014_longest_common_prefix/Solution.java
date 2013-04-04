package q01x.q014_longest_common_prefix;


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
