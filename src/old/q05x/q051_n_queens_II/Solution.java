/**
 * Solution.java
 * @author leo
 * @date 2013-4-3
 */
package old.q05x.q051_n_queens_II;

import java.util.Arrays;

/**
 * <pre>
 * N-Queens II
 * Follow up for N-Queens problem.
 * 
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    public static void  main(String [] args) {
        Solution s = new Solution();
        System.out.println(s.totalNQueens(4));
    }

    public int totalNQueens(int n) {
        if (n == 1) {
            return 1;
        } else if (n < 4) {
            return 0;
        }
        int[] pos = new int [n];
        Arrays.fill(pos, -1);
        return solve(pos, 0);
   }
    
    private int solve(int[] pos, int i) {
        if (i == pos.length) {
            return 1;
        }
        int sol = 0;
        for (int j = 0; j < pos.length; j ++) {
            pos[i] = j;
            if (safe(pos, i)) {
                sol += solve(pos, i + 1);
            }
        }
        pos[i] = -1;
        return sol;
    }

    private boolean safe(int[]pos, int i) {
        for (int k = 0; k < i; k ++) {
            int diff = Math.abs(pos[k] - pos[i]);
            if (diff == 0 || diff == Math.abs(k - i)) {
                return false;
            }
        }
        return true;
    }
}