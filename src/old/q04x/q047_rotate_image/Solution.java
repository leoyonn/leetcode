/**
 * Solution.java
 * @author leo
 * @date 2013-4-3
 */
package old.q04x.q047_rotate_image;

/**
 * <pre>
 * Rotate Image
 * You are given an n x n 2D matrix representing an image.
 * 
 * Rotate the image by 90 degrees (clockwise).
 * 
 * Follow up:
 * Could you do this in-place?
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length < 2) {
            return;
        }
        int n = matrix.length;
        for (int d = 0; d < n / 2; d ++) {
            for (int i = d; i < n - d - 1; i ++) {
                int t = matrix[d][i];
                matrix[d][i] = matrix[n - 1 - i][d];
                matrix[n - 1 - i][d] = matrix[n - 1 - d][n - 1 - i];
                matrix[n - 1 - d][n - 1 - i] = matrix[i][n - 1 - d];
                matrix[i][n - 1 - d] = t;
            }
        }
    }
}
