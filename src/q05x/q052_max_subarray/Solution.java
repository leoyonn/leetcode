/**
 * Solution.java
 * @author leo
 * @date 2013-4-3
 */
package q05x.q052_max_subarray;


/**
 * <pre>
 * Maximum Subarray
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * 
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    public static void  main(String [] args) {
        Solution s = new Solution();
        System.out.println(s.maxSubArray(new int[]{-3,-2,1,2,2,0,1,0}));
    }

    public int maxSubArray(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        } else if (A.length == 1) {
            return A[0];
        }
        int max = A[0], cur = 0;
        for (int i = 0; i < A.length; i ++) {
            cur += A[i];
            if (max < cur) {
                max = cur;
            }
            if (cur < 0) {
                cur = 0;
            }
        }
        return max;
    }
}