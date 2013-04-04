/**
 * Solution.java
 * @author leo
 * @date 2013-4-3
 */
package q04x.q041_trapping_rain_water;


/**
 * <pre>
 * Trapping Rain WaterMar 10 '12
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 *  compute how much water it is able to trap after raining.
 * 
 * For example, 
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    public static void main(String [] args) {
        Solution s = new Solution();
        System.out.println(s.trap(new int[]{3,4,0,1}));
    }

    public int trap(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        // find ridge
        int ridge = 0;
        for (int i = 1; i < A.length; i ++) {
            if (A[ridge] < A[i]) {
                ridge = i;
            }
        }
        if (A[ridge] == 0) {
            return 0;
        }
        // from left to ridge
        int dam = A[0], res = 0;
        for (int i = 1; i < ridge; i ++) {
            if (A[i] < dam) {
                res += dam - A[i];
            } else if (A[i] > dam) {
                dam = A[i];
            }
        }
        // from right to ridge
        dam = A[A.length - 1];
        for (int i = A.length - 2; i > ridge; i --) {
            if (A[i] < dam) {
                res += dam - A[i];
            } else if (A[i] > dam) {
                dam = A[i];
            }
        }
        return res;
    }
}
