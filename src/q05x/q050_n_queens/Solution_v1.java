/**
 * Solution.java
 * @author leo
 * @date 2013-4-3
 */
package q05x.q050_n_queens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
public class Solution_v1 {
    public static void  main(String [] args) {
        Solution_v1 s = new Solution_v1();
        ;
        for (String[] r: s.solveNQueens(4)) {
            System.out.println(Arrays.toString(r));
        }
    }

    private static enum State {
        Q, DANGER, SAFE,
    }
    
    private static class Pos {
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
        int x;
        int y;
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
        State[][] board = new State[n][n];
        for (int i = 0; i < board.length; i ++) {
            Arrays.fill(board[i], State.SAFE);
        }
        solve(board, 0);
        return res;
   }
    
    private void solve(State[][] board, int i) {
        if (i == board.length) {
            res.add(save(board));
            return;
        }
        for (int j = 0; j < board.length; j ++) {
            if (board[i][j] == State.SAFE) {
                board[i][j] = State.Q;
                List<Pos> hold = flushOut(board, i, j);
                solve(board, i + 1);
                board[i][j] = State.SAFE;
                free(hold, board);
            }
        }
    }

    private List<Pos> flushOut(State[][]board, int i, int j) {
        List<Pos> hold = new ArrayList<Pos>();
        int d45x = j + i, d135x = j - i;
        for (int k = 0; k < board.length; k ++) {
            occupy(board, i, k, hold);          // |
            occupy(board, k, j, hold);          // _
            occupy(board, k, d45x - k, hold);   // /
            occupy(board, k, d135x + k, hold);  // \
        }
        return hold;
    }
    
    private void occupy(State[][] board, int y, int x, List<Pos> hold) {
        if (y < 0 || y >= board.length || x < 0 || x >= board.length) {
            return;
        }
        if (board[y][x] == State.SAFE) {
            board[y][x] = State.DANGER;
            hold.add(new Pos(x, y));
        }
    }

    private void free(List<Pos> hold, State[][]board) {
        for (Pos pos : hold) {
            board[pos.y][pos.x] = State.SAFE;
        }
    }

    private String[] save(State[][] board) {
        String[] r = new String[board.length];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i ++) {
            sb.setLength(0);
            for (State s: board[i]) {
                sb.append(s == State.Q ? 'Q' : '.');
            }
            r[i] = sb.toString();
        }
        return r;
    }
}