/**
 * Solution.java
 * @author leo
 * @date 2013-3-31
 */
package q06x.q062_unique_paths_II;


/**
 * <pre>
 * Unique Paths II
 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * The total number of unique paths is 2.
 * Note: m and n will be at most 100.
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.uniquePathsWithObstacles(new int[][]{{0,0}}));
    }

    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if (m == 0 || n == 0) {
            return 0;
        }
        int[]path = new int[n];
        // first row
        for (int j = 0; j < n; j ++) {
            path[j] = 1 - grid[0][j];
            if (path[j] == 0) {
                break;
            }
        }
        // remain rows
        for (int i = 1; i < m; i ++) {
            if (grid[i][0] == 1) {
                path[0] = 0;
            }
            for (int j = 1; j < n; j ++) {
                if (grid[i][j] == 1) {
                    path[j] = 0;
                } else {
                    path[j] = path[j] + path[j - 1];
                }
            }
        }
        return path[n - 1];
    }
}
