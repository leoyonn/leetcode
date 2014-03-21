/**
 * Solution.java
 * @author leo
 * @date 2013-4-5
 */
package old.q07x.q074_search_matrix;



/**
 * <pre>
 * Search a 2D Matrix 303 / 650
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * 
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * For example,
 * 
 * Consider the following matrix:
 * [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * Given target = 3, return true
 * </pre>
 * 
 * TLE ON LARGE...
 * @author leo
 */
public class Solution_v2 {
    public static void main(String[] args) {
        int[][] a = new int[][]{{1,3,5,7}, {10,11,16,20},{23,30,34,50}};
        System.out.println(new Solution_v2().searchMatrix(a, 11));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        // find the row
        int l = 0, r = m - 1, idx = 0;
        while (l <= r) {
            idx = (l + r) >> 1;
            int v = matrix[idx][0];
            if (v == target) {
                return true;
            } else if (v < target) {
                l = idx + 1;
            } else {
                r = idx - 1;
            }
        }
        if (idx == 0 && matrix[idx][0] > target) {
            return false;
        } else if (matrix[idx][n - 1] < target) {
            return false;
        }
        int row = matrix[idx][0] > target ? idx - 1 : idx;
        // find in the row
        l = 0; r = n - 1;
        while (l <= r) {
            idx = (l + r) >> 1;
            int v = matrix[row][idx];
            if (v == target) {
                return true;
            } else if (v < target) {
                l = idx + 1;
            } else {
                r = idx - 1;
            }
        }
        return false;
    }
}
