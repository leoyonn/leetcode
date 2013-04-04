/**
 * Solution.java
 * @author leo
 * @date 2013-4-2
 */
package q032_search_in_rotated_array;


/**
 * <pre>
 * Search in Rotated Sorted Array
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * You are given a target value to search.
 *  If found in the array return its index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
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

    public int search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int l = 0, r = A.length - 1, m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (A[m] == target) {
                return m;
            } else if (m == l) { // 1 or 2 values
                return A[r] == target ? r : -1;
            }
            if (A[m] > A[l]) { // divide in second half
                if (A[m] < target || A[l] > target) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else { // divide in first half
                if (A[r] < target || A[m] > target) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }
        return -1;
    }

}
