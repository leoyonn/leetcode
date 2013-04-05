/**
 * Solution.java
 * @author leo
 * @date 2013-4-5
 */
package q07x.q073_set_matrix_zeroes;

import java.util.Arrays;


/**
 * <pre>
 * Set Matrix Zeroes 277 / 625
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * 
 * Follow up:
 * Did you use extra space?
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    public static void main(String[] args) {
        int[][] a = new int[][]{{0,1},{1,1}};
        new Solution().setZeroes(a);
        for (int i = 0; i < a.length; i ++) {
            System.out.println(Arrays.toString(a[i]));
        }
        System.out.println();
    }

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int m = matrix.length, n = matrix[0].length;
        // cache first row and first column
        boolean c0zero = false, r0zero = false;
        for (int i = 0; i < m; i ++) {
            if (matrix[i][0] == 0) {
                c0zero = true;
                break;
            }
        }
        for (int i = 0; i < n; i ++) {
            if (matrix[0][i] == 0) {
                r0zero = true;
                break;
            }
        }
        // mark all 0's into first row and column
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // zero all rows and columns except c0 an r0
        for (int i = 1; i < m; i ++) {
            if (matrix[i][0] == 0) {
                zeroRow(matrix, i);
            }
        }
        for (int i = 1; i < n; i ++) {
            if (matrix[0][i] == 0) {
                zeroCol(matrix, i);
            }
        }
        // set first col and first row
        if (c0zero) {
            zeroCol(matrix, 0);
        }
        if (r0zero) {
            zeroRow(matrix, 0);
        }
    }
    
    private void zeroRow(int[][]m, int r) {
        for (int i = r == 0 ? 0 : 1; i < m[r].length; i ++) {
            m[r][i] = 0;
        }
    }
    
    private void zeroCol(int[][]m, int c) {
        for (int i = c == 0 ? 0 : 1; i < m.length; i ++) {
            m[i][c] = 0;
        }
    }
}
