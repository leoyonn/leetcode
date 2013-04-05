/**
 * Solution.java
 * @author leo
 * @date 2013-3-31
 */
package q06x.q066_valid_number;

import java.util.Arrays;



/**
 * <pre>
 * Plus One 290 / 689
 * Given a number represented as an array of digits, plus one to the number.
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[]{1};
        }
        int i;
        for (i = digits.length - 1; i >= 0 && digits[i] == 9; i --);
        if (i >= 0) {
            digits[i] ++;
            Arrays.fill(digits, i + 1, digits.length, 0);
            return digits;
        }
        int[] a = new int[digits.length + 1];
        a[0] = 1;
        return a;
    }
}
