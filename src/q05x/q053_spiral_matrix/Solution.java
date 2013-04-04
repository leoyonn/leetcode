/**
 * Solution.java
 * @author leo
 * @date 2013-4-3
 */
package q05x.q053_spiral_matrix;

import java.util.ArrayList;


/**
 * <pre>
 * Spiral Matrix
 * Given a matrix of m x n elements (m rows, n columns),
 *  return all elements of the matrix in spiral order.
 * 
 * For example,
 * Given the following matrix:
 * 
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    public static void  main(String [] args) {
        Solution s = new Solution();
        System.out.println(s.spiralOrder(new int[][] {
                {1, 2, 3},
            }));
    }

    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int m = matrix.length, n = matrix[0].length, d, i, min = m > n ? n : m;
        for (d = 0; d < min / 2; d ++) {
            for (i = d; i < n - d - 1; i ++) res.add(matrix[d][i]);
            for (i = d; i < m - d - 1; i ++) res.add(matrix[i][n - 1 - d]);
            for (i = n - 1 - d; i > d; i --) res.add(matrix[m - 1 - d][i]);
            for (i = m - 1 - d; i > d; i --) res.add(matrix[i][d]);
        }
        if ((min & 1) == 1) {
            if (m < n) {
                for (i = d; i <= n - d - 1; i ++) res.add(matrix[d][i]);
            } else {
                for (i = d; i <= m - d - 1; i ++) res.add(matrix[i][d]);
            }
        }
        return res;
   }
}