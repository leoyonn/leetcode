/**
 * Solution.java
 * @author leo
 * @date 2013-3-31
 */
package old.q06x.q063_min_path_sum;


/**
 * <pre>
 * Minimum Path Sum
 * Given a m x n grid filled with non-negative numbers,
 *  find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minPathSum(new int[][]{{1,2},{3,1}}));
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if (m == 0 || n == 0) {
            return 0;
        }
        int[]path = new int[n];
        // first row
        path[0] = grid[0][0];
        for (int j = 1; j < n; j ++) {
            path[j] = path[j - 1] + grid[0][j];
        }
        // remain rows
        for (int i = 1; i < m; i ++) {
            path[0] += grid[i][0];
            for (int j = 1; j < n; j ++) {
                path[j] = Math.min(path[j], path[j - 1]) + grid[i][j];
            }
        }
        return path[n - 1];
    }
}
