/**
 * Solution.java
 * @author leo
 * @date 2013-4-2
 */
package q034_search_insert_position;


/**
 * <pre>
 * Search Insert Position
 * Given a sorted array and a target value, return the index if the target is found.
 *  If not, return the index where it would be if it were inserted in order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Here are few examples.
 * [1,3,5,6], 5 ¡ú 2
 * [1,3,5,6], 2 ¡ú 1
 * [1,3,5,6], 7 ¡ú 4
 * [1,3,5,6], 0 ¡ú 0
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    public static void main(String [] args) {
        Solution s = new Solution();
        int[] a = new int[] {
                1,3,5
        };
        System.out.println(s.searchInsert(a, 7));
    }

    public int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int l = 0, r = A.length - 1, m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (A[m] == target) {
                return m;
            } else if (A[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

}
