/**
 * Solution.java
 * @author leo
 * @date 2013-3-31
 */
package q06x.q065_add_binary;



/**
 * <pre>
 * Add Binary 271 / 815
 * Given two binary strings, return their sum (also a binary string).
 * 
 * For example,
 * a = "11"
 * b = "1"
 * Return "100"
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().addBinary("10", "1110"));
    }

    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0 || a.equals("0")) {
            return b;
        } else if (b == null || b.length() == 0 || b.equals("0")) {
            return a;
        }
        int max = Math.max(a.length(), b.length());
        char[]sum = new char[max + 1];
        int carry = 0;
        for (int i = 0; i < max; i ++) {
            int ca = 0, cb = 0;
            if (i < a.length()) {
                ca = a.charAt(a.length() - 1 - i) - '0';
            }
            if (i < b.length()) {
                cb = b.charAt(b.length() - 1 - i) - '0';
            }
            carry += ca + cb;
            sum[max - i] = (char) ((carry & 1) + '0');
            carry >>= 1;
        }
        if (carry == 1) {
            sum[0] = '1';
        }
        return String.valueOf(sum, 1 - carry, max + carry);
   }
}