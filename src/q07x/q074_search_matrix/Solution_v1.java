/**
 * Solution.java
 * @author leo
 * @date 2013-4-5
 */
package q07x.q074_search_matrix;



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
 * @author leo
 */
public class Solution_v1 {
    public static void main(String[] args) {
        int[][] a = new int[][]{{1,1}};
        System.out.println(new Solution_v1().searchMatrix(a, 2));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = m * n - 1, idx;
        while (l <= r) {
            idx = (l + r) / 2;
            int v = matrix[idx / n][idx % n];
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
