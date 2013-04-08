/**
 * Solution.java
 * @author leo
 * @date 2013-3-21
 */
package q01x.q018_letter_combination_phone;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * Letter Combinations of a Phone Number 383 / 1044
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * 
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 * </pre>
 * 
 * @author leo
 */
public class Solution {
	public static void main(String [] args) {
		Solution s = new Solution();
		System.out.println(s.letterCombinations("23"));
		for (char[] cc : LETTERS) {
			System.out.print(cc.length);
			for (char c : cc) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
	
	final static char[][] LETTERS = new char[][] {
			{'a', 'b', 'c'},
			{'d', 'e', 'f'},
			{'g', 'h', 'i'},
			{'j', 'k', 'l'},
			{'m', 'n', 'o'},
			{'p', 'q', 'r', 's'},
			{'t', 'u', 'v'},
			{'w', 'x', 'y', 'z'},
	};

	private void combine(char[]a, int idx, char[] buf, List<String> res) {
		if (idx == a.length) {
			res.add(new String(buf));
			return;
		}
		for (char c: LETTERS[a[idx] - '2']) {
			buf[idx] = c;
			combine(a, idx + 1, buf, res);
		}
	}

	public ArrayList<String> letterCombinations(String digits) {
    	ArrayList<String> res = new ArrayList<String>();
    	if (digits == null || digits.length() == 0) {
    		res.add("");
    		return res;
    	}
    	char[] arr = digits.toCharArray();
    	char[] buf = new char[arr.length];
    	combine(arr, 0, buf, res);
        return res;
    }
}
