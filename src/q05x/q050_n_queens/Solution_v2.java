/**
 * Solution.java
 * @author leo
 * @date 2013-4-3
 */
package q05x.q050_n_queens;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>
 * N-Queens
 * The n-queens puzzle is the problem of placing n queens on an n*n chessboard
 *  such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement,
 *  where 'Q' and '.' both indicate a queen and an empty space respectively.
 * 
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 * 
 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 * 
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * </pre>
 * 
 * @author leo
 */
public class Solution_v2 {
    public static void  main(String [] args) {
        Solution_v2 s = new Solution_v2();
        for (String[] r: s.solveNQueens(4)) {
            System.out.println(Arrays.toString(r));
        }
    }

    private ArrayList<String[]> res = new ArrayList<String[]>();
    public ArrayList<String[]> solveNQueens(int n) {
        res.clear();
        if (n < 4) {
            if (n == 1) {
                res.add(new String[]{"Q"});
            }
            return res;
        }
        boolean[][] board = new boolean[n][n];
        for (int i = 0; i < board.length; i ++) {
            Arrays.fill(board[i], false);
        }
        solve(board, 0);
        return res;
   }
    
    private void solve(boolean[][] board, int i) {
        if (i == board.length) {
            res.add(save(board));
            return;
        }
        for (int j = 0; j < board.length; j ++) {
            if (!board[i][j] && safe(board, i, j)) {
                board[i][j] = true;
                solve(board, i + 1);
                board[i][j] = false;
            }
        }
    }

    private boolean safe(boolean[][]board, int i, int j) {
        int d45x = j + i, d135x = j - i;
        for (int k = 0; k < board.length; k ++) {
            if (board[i][k]) return false;
            if (board[k][j]) return false;
            if (d45x - k >= 0 && d45x - k < board.length && board[k][d45x - k]) return false;
            if (d135x + k >= 0 && d135x + k < board.length && board[k][d135x + k]) return false;
        }
        return true;
    }
    
    private String[] save(boolean[][] board) {
        String[] r = new String[board.length];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i ++) {
            sb.setLength(0);
            for (boolean b: board[i]) {
                sb.append(b ? 'Q' : '.');
            }
            r[i] = sb.toString();
        }
        return r;
    }
}