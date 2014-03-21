/**
 * Solution.java
 * @author leo
 * @date 2013-4-6
 */
package old.q08x.q080_remove_dup_II;


/**
 * <pre>
 * Remove Duplicates from Sorted Array II
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * 
 * For example,
 * Given sorted array A = [1,1,1,2,2,3],
 * 
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    public int removeDuplicates(int[] A) {
        if (A.length < 3) {
            return A.length; 
        }
        int i = 0, j = 1;
        while (j < A.length) {
            if (A[i] == A[j]) {
                A[++i] = A[j++];
            }
            while (j < A.length && A[i] == A[j]) j ++;
            if (j < A.length) {
                A[++i] = A[j++];
            }
        }
        return i + 1;
    }
}
