/**
 * Solution.java
 * @author leo
 * @date 2014-3-13
 */
package p01x.p015_Single_Number;


/**
 * <pre>
 * Given an array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * </pre>
 *
 * @author leo
 */
public class Solution {
    /**
     * 14 / 14 test cases passed.
     * Status: Accepted
     * Runtime: 372 ms
     *
     * @param A
     * @return
     */
    public int singleNumber(int[] A) {
        int r = 0;
        for (int i = 0; i < A.length; i++) {
            r ^= A[i];
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().singleNumber(new int[]{2, 2, 3, 3, 4}));
    }
}
 