/**
 * Solution.java
 * @author leo
 * @date 2013-3-31
 */
package q06x.q061_unique_paths;

import java.util.Arrays;

/**
 * <pre>
 * Unique Paths
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * 
 * The robot can only move either down or right at any point in time.
 *  The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * 
 * How many possible unique paths are there?
 * Note: m and n will be at most 100.
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.uniquePaths(3, 3));
    }

    public int uniquePaths(int m, int n) {
        if (m < 2 || n < 2) {
            return 1;
        }
        int[]path = new int[n];
        Arrays.fill(path, 1);
        for (int i = 1; i < m; i ++) {
            for (int j = 1; j < n; j ++) {
                path[j] = path[j] + path[j - 1];
            }
        }
        return path[n - 1];
    }
}
