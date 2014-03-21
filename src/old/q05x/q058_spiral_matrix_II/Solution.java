/**
 * Solution.java
 * @author leo
 * @date 2013-4-3
 */
package old.q05x.q058_spiral_matrix_II;



/**
 * <pre>
 * Spiral Matrix II
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * 
 * For example,
 * Given n = 3,
 * 
 * You should return the following matrix:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];
        int i, d, idx = 0; 
        for (d = 0; d < n / 2; d ++) {
            for (i = d; i < n - d - 1; i ++) mat[d][i] = ++idx;
            for (i = d; i < n - d - 1; i ++) mat[i][n - 1 - d] = ++idx;
            for (i = n - 1 - d; i > d; i --) mat[n - 1 - d][i] = ++idx;
            for (i = n - 1 - d; i > d; i --) mat[i][d] = ++idx;
        }
        if ((n & 1) == 1) {
            mat[d][d] = ++idx;
        }
        return mat;
    }
}
