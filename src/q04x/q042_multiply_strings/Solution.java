/**
 * Solution.java
 * @author leo
 * @date 2013-4-3
 */
package q042_multiply_strings;



/**
 * <pre>
 * Multiply Strings
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * Note: The numbers can be arbitrarily large and are non-negative.
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    public static void main(String [] args) {
        Solution s = new Solution();
        long l = 19000L;
        System.out.println(l * l);
        System.out.println(s.multiply(String.valueOf(l), String.valueOf(l)));
    }

    private static final int SPLEN = 4;
    private static final int BASE = (int) Math.pow(10, SPLEN);

    private class Big {
        private int []v;
        private int size = 0;
        public Big(String data) {
            size = (data.length() + 3) / SPLEN; 
            v = new int[size];
            for (int idx = data.length(), i = 0; idx > 0; idx -= SPLEN, i ++) {
                int end = idx, start = end - SPLEN < 0 ? 0 : end - SPLEN;
                v[i] = Integer.valueOf(data.substring(start, end));
            }
        }

        public Big(int[] v) {
            this.v = v;
            int i = v.length - 1;
            while (i > 0 && v[i] == 0) {
                i --;
            }
            this.size = i + 1;
        }

        public Big mult(Big that) {
            int[] r = new int[size + that.size];
            int carry = 0, i = 0, j = 0;
            for (; i < size; i ++) {
                for (j = 0; j < that.size; j ++) {
                    int p = r[i + j] + v[i] * that.v[j] + carry;
                    if (p > BASE) {
                        carry = p / BASE;
                        p -= carry * BASE;
                    } else {
                        carry = 0;
                    }
                    r[i + j] = p;
                }
                r[i + j] += carry;
                carry = 0;
            }
            return new Big(r);
        }

        @Override
        public String toString() {
            StringBuilder buf = new StringBuilder(size > 0 ? String.valueOf(v[size - 1]) : "");
            for (int i = size - 2; i >= 0; i --) {
                buf.append(String.format("%04d", v[i]));
            }
            String r = buf.toString();
            return r.length() == 0 ? "0" : r;
        }
    }

    public String multiply(String num1, String num2) {
        if (num1 == null || num1.length() == 0
                || num2 == null || num2.length() == 0
                || num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        Big n1 = new Big(num1), n2 = new Big(num2);
        return n1.mult(n2).toString();
    }
}
