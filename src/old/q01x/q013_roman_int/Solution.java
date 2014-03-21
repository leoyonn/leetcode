/**
 * Solution.java
 * @author leo
 * @date 2013-3-21
 */
package old.q01x.q013_roman_int;

/**
 * <pre>
 * Roman to Integer 339 / 754
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * </pre>
 * 
 * @author leo
 */
public class Solution {
	public static void main(String [] args) {
		Solution s = new Solution();
		System.out.println(s.romanToInt("I"));
		System.out.println(s.romanToInt("MMMCMXCIX"));
	}

	private int v(char c) {
		switch (c) {
		case 'M': return 1000;
		case 'D': return 500;
		case 'C': return 100;
		case 'L': return 50;
		case 'X': return 10;
		case 'V': return 5;
		case 'I': return 1;
		default: return 0;
		}
	}

	public int romanToInt(String s) {
    	char last = '^', cur = '^', next = '^';
    	int result = 0;
    	for (int i = 0; i < s.length(); i ++) {
    		next = i == s.length() - 1 ? '$' : s.charAt(i + 1);
    		cur = s.charAt(i);
    		int vcur = v(cur);
    		if (cur == last || cur == next || vcur > v(next)) {
    			result += vcur;
    		} else { // v(cur) < v(next)
    			result -= vcur;
    		}
    		last = cur;
    	}
    	return result;
    }
}
