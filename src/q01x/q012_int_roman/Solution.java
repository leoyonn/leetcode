/**
 * Solution.java
 * @author leo
 * @date 2013-3-21
 */
package q01x.q012_int_roman;

/**
 * <pre>
 * Integer to Roman 320 / 755
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 * </pre>
 * 
 * @author leo
 */
public class Solution {
	public static void main(String [] args) {
		Solution s = new Solution();
		System.out.println(s.intToRoman(1));
		System.out.println(s.intToRoman(3999));
	}

    public String intToRoman(int num) {
    	int m = num / 1000, 
    	c = (num %= 1000) / 100,
    	x = (num %= 100) / 10,
    	i = num % 10;
    	StringBuilder sb = new StringBuilder();
    	sb.append(romM(m)).append(romC(c)).append(romX(x)).append(romI(i));
        return sb.toString();
    }
    
    private String romM(int m) {
    	return m == 3 ? "MMM" : m == 2 ? "MM" : m == 1 ? "M" : "";
    }

    private String romC(int c) {
    	switch (c) {
    	case 1: return "C";
    	case 2: return "CC";
    	case 3: return "CCC";
    	case 4: return "CD";
    	case 5: return "D";
    	case 6: return "DC";
    	case 7: return "DCC";
    	case 8: return "DCCC";
    	case 9: return "CM";
    	default:return "";
    	}
    }
	private String romX(int x) {
    	switch (x) {
    	case 1: return "X";
    	case 2: return "XX";
    	case 3: return "XXX";
    	case 4: return "XL";
    	case 5: return "L";
    	case 6: return "LX";
    	case 7: return "LXX";
    	case 8: return "LXXX";
    	case 9: return "XC";
    	default:return "";
    	}
	}

	private String romI(int i) {
    	switch (i) {
    	case 1: return "I";
    	case 2: return "II";
    	case 3: return "III";
    	case 4: return "IV";
    	case 5: return "V";
    	case 6: return "VI";
    	case 7: return "VII";
    	case 8: return "VIII";
    	case 9: return "IX";
    	default:return "";
    	}
	}
}
