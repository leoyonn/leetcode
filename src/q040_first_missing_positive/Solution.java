/**
 * Solution.java
 * @author leo
 * @date 2013-4-3
 */
package q040_first_missing_positive;


/**
 * <pre>
 * First Missing Positive
 * Given an unsorted integer array, find the first missing positive integer.
 * 
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * 
 * Your algorithm should run in O(n) time and uses constant space.
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    public static void main(String [] args) {
        Solution s = new Solution();
        System.out.println(s.firstMissingPositive(new int[]{3,4,-1,1}));
    }

    private void swap(int[]A, int i, int j) {
        A[i] ^= A[j];
        A[j] ^= A[i];
        A[i] ^= A[j];
    }

    public int firstMissingPositive(int[] A) {
        if (A == null || A.length == 0) {
            return 1;
        }
        for (int i = 0; i < A.length; i ++) {
            while (A[i] > 0 && A[i] < A.length && A[i] != i + 1) {
                swap(A, i, A[i] - 1);
            }
        }
        for (int i = 0; i < A.length; i ++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }
        return A.length + 1;
    }
}
