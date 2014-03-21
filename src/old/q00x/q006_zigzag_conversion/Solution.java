/**
 * Solution.java
 * @author leo
 * @date 2013-3-21
 */
package old.q00x.q006_zigzag_conversion;

/**
 * <pre>
 * ZigZag Conversion 523 / 1438
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 *  (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * 
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * </pre>
 * 
 * @author leo
 */
public class Solution {
	public static void main(String [] args) {
		Solution s = new Solution();
		System.out.println(s.convert("A", 1));
	}
	
    public String convert(String s, int nRows) {
    	if (nRows == 1 || s == null || s.length() < 2) {
    		return s;
    	}
    	char[] res = new char[s.length()];
    	int L = nRows - 1, t = 0;
    	for (int l = 0; l <= L; l ++) {
        	for (int i = l; i < s.length(); ) {
        		res[t ++] = s.charAt(i);
        		if (l == 0 || l == L) {
        			i += 2 * L;
        		} else if (i % L == l) {
        			i += (L - l) * 2;
        		} else {
        			i += l * 2;
        		}
        	}
    	}
        return new String(res);
    }
}