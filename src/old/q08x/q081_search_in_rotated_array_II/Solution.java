/**
 * Solution.java
 * @author leo
 * @date 2013-4-2
 */
package old.q08x.q081_search_in_rotated_array_II;


/**
 * <pre>
 * Search in Rotated Sorted Array II 247 / 659
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * 
 * Would this affect the run-time complexity? How and why?
 * 
 * Write a function to determine if a given target is in the array.
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    public static void main(String [] args) {
        Solution s = new Solution();
        int[] a = new int[] {
            0, 0, 0, 0, 1, 2, 3, 3, 4, 5, 6, 6, 7, 8, 8, 8, 9, 9, 10, 10, 11, 11,
        };
        System.out.println(s.search(a, 0));
    }

    public boolean search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return false;
        }
        int l = 0, r = A.length - 1, m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (A[m] == target) {
                return true;
            } else if (m == l) { // 1 or 2 values
                return A[r] == target;
            }
            if (A[m] > A[l]) { // divide in second half
                if (A[m] > target && target >= A[l]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else if (A[m] < A[l]) { // divide in first half
                if (A[r] >= target && A[m] < target) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {
                l ++;
            }
        }
        return false;
    }
}
