package q006_zigzag_conversion;

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