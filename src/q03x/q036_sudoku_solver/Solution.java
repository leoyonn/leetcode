/**
 * Solution.java
 * @author leo
 * @date 2013-4-2
 */
package q03x.q036_sudoku_solver;

import java.util.Arrays;


/**
 * <pre>
 * Sudoku Resolver
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * 
 * Empty cells are indicated by the character '.'.
 * 
 * You may assume that there will be only one unique solution. *
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    public static void main(String [] args) {
        Solution s = new Solution();
        char[][] a = {
            "53..7....".toCharArray(), "6..195...".toCharArray(), ".98....6.".toCharArray(),
            "8...6...3".toCharArray(), "4..8.3..1".toCharArray(), "7...2...6".toCharArray(),
            ".6....28.".toCharArray(), "...419..5".toCharArray(), "....8..79".toCharArray()
        };
        s.solveSudoku(a);
        for (char[] row: a) {
            System.out.println(Arrays.toString(row));
        }
    }

    private boolean check(char[][]board, int i, int j) {
        boolean check[] = new boolean[9];
        // check row
        for (int x = 0; x < 9; x ++) {
            if (board[i][x] == '.') {
                continue;
            } else if (check[board[i][x] - '1']) {
                return false;
            }
            check[board[i][x] - '1'] = true;
        }
        // check column
        Arrays.fill(check, false);
        for (int y = 0; y < 9; y ++) {
            if (board[y][j] == '.') {
                continue;
            } else if (check[board[y][j] - '1']) {
                return false;
            }
            check[board[y][j] - '1'] = true;
        }
        // check 3x3
        Arrays.fill(check, false);
        int si = i - i % 3, sj = j - j % 3; 
        for (int d = 0; d < 9; d ++) {
            int y = si + d / 3, x = sj + d % 3;
            if (board[y][x] == '.') {
                continue;
            } else if (check[board[y][x] - '1']) {
                return false;
            }
            check[board[y][x] - '1'] = true;
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9) {
            return;
        }
        solve(board, 0);
    }

    public boolean solve(char[][] board, int idx) {
        if (idx == 81) {
            return true;
        }
        int i = idx / 9, j = idx % 9;
        if (board[i][j] != '.') {
            return solve(board, idx + 1);
        }
        for (char c = '1'; c <= '9'; c++) {
            board[i][j] = c;
            if (check(board, i, j) && solve(board, idx + 1)) {
                return true;
            }
        }
        board[i][j] = '.';
        return false;
    }
}
