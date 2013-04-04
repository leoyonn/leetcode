/**
 * Solution.java
 * @author leo
 * @date 2013-4-2
 */
package q03x.q033_search_for_a_range;


/**
 * <pre>
 * Search for a Range
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4]. *
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
        System.out.println(s.searchRange(a, 0)[1]);
    }

    public int[] searchRange(int[] A, int target) {
        if (A == null || A.length == 0) {
            return new int[]{-1, -1};
        }
        int l = 0, r = A.length - 1, m = 0, first = -1, last = -1;
        while (l <= r) {
            m = (l + r) / 2;
            // only find in left or right
            if (A[m] < target) {
                l = m + 1;
            } else if (A[m] > target) {
                r = m - 1;
            } else {
                break;
            }
        }
        if (A[m] != target) {
            return new int[]{-1, -1};
        }
        // found in mid
        first = last = m;
        if (m > l && A[m - 1] == target) {
            first = findFirst(A, l, m - 1, target);
        }
        if (m < r && A[m + 1] == target) {
            last = findLast(A, m + 1, r, target);
        }
        return new int[] {first, last};
    }
    
    private int findFirst(int[] A, int l, int r, int target) {
        int first = r;
        while (l <= r) {
            int m = (l + r) / 2;
            if (A[m] == target) {
                first = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return first;
    }

    private int findLast(int[] A, int l, int r, int target) {
        int last = l;
        while (l <= r) {
            int m = (l + r) / 2;
            if (A[m] == target) {
                last = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return last;
    }
}
