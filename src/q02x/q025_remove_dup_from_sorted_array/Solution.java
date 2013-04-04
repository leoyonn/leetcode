/**
 * Solution.java
 * @author leo
 * @date 2013-3-31
 */
package q02x.q025_remove_dup_from_sorted_array;

/**
 * @author leo
 */
public class Solution {
	public static void main(String [] args) {
		Solution s = new Solution();
        System.out.println(s.removeDuplicates(new int[]{1}));
        System.out.println(s.removeDuplicates(new int[]{1, 1}));
        System.out.println(s.removeDuplicates(new int[]{1, 1, 1}));
        System.out.println(s.removeDuplicates(new int[]{1, 1, 2, 4}));
	}

	public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        } else if (A.length == 1) {
            return 1;
        }
        int i = 0, j = 1;
        while (i < A.length) {
            while (j < A.length && A[j] == A[i]) {
                j ++;
            }
            if (j >= A.length) {
                break;
            }
            A[++i] = A[j++];
        }
        return i + 1;
    }
}
