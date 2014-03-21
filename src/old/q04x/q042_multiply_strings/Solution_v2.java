/**
 * Solution.java
 * @author leo
 * @date 2013-4-3
 */
package old.q04x.q042_multiply_strings;


/**
 * <pre>
 * Multiply Strings
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * Note: The numbers can be arbitrarily large and are non-negative.
 * </pre>
 * 
 * @author leo
 */
public class Solution_v2 {
    public static void main(String [] args) {
        Solution_v2 s = new Solution_v2();
        long l = 19000L;
        System.out.println(l * l);
        System.out.println(s.multiply(String.valueOf(l), String.valueOf(l)));
    }

    public String multiply(String num1, String num2) {
        if (num1 == null || num1.length() == 0
                || num2 == null || num2.length() == 0
                || num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] res = mult(num1.toCharArray(), num2.toCharArray());
        StringBuilder buf = new StringBuilder();
        int i;
        for (i = res.length - 1; i >= 0 && res[i] == 0; i --);
        for (; i >= 0; i --) {
            buf.append(res[i]);
        }
        return buf.toString();
    }
    
    private int[] mult(char[] n1, char[] n2) {
        int carry = 0;
        int[] res = new int[n1.length + n2.length];
        for (int i = 0; i < n1.length; i ++) {
            int b1 = n1[n1.length - 1 - i] - '0';
            for (int j = 0; j < n2.length; j ++) {
                int r = carry + res[i + j] + b1 * (n2[n2.length - 1 - j] - '0'); 
                res[i + j] = r % 10;
                carry = r / 10;
            }
            res[i + n2.length] += carry;
            carry = 0;
        }
        return res;
    }
}
