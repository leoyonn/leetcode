/**
 * Solution.java
 * @author leo
 * @date 2014-3-13
 */
package p01x.p014_Single_Number_II;


/**
 * <pre>
 * Given an array of integers, every element appears three times except for one. Find that single one.
 *
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * </pre>
 *
 * @author leo
 */
public class Solution {
    /**
     * 11 / 11 test cases passed.
     * Status: Accepted
     * Runtime: 376 ms
     *
     * @param A
     * @return
     */
    public int singleNumber1(int[] A) {
        int r = 0;
        for (int b = 0; b < 32; b++) {
            int mask = 1 << b, c = 0;
            for (int i = 0; i < A.length; i++) {
                if ((A[i] & mask) != 0) {
                    c++;
                }
                ;
            }
            if (c % 3 != 0) {
                r |= mask;
            }
        }
        return r;
    }

    /**
     * 11 / 11 test cases passed.
     * Status: Accepted
     * Runtime: 376 ms
     *
     * @param A
     * @return
     */
    public int singleNumber(int[] A) {
        int ones = 0, twos = 0, threes;
        for (int i = 0; i < A.length; i++) {
            twos |= ones & A[i];
            ones ^= A[i];
            threes = ones & twos;
            ones &= ~threes;
            twos &= ~threes;
            ;
        }
        return ones;
    }

    public static void main(String[] args) {
        System.out.println(0 ^ 1);
        System.out.println(new Solution().singleNumber(new int[]{2, 2, 2, 3, 3, 3, 4}));
    }
}
