/**
 * Solution.java
 * @author leo
 * @date 2013-4-2
 */
package old.q03x.q035_valid_sudoku;

import java.util.Arrays;


/**
 * <pre>
 * Valid Sudoku
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
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
                
        System.out.println(s.isValidSudoku(a));
    }

    private boolean check(boolean[]check, char c) {
        if (c == '.') {
            return true;
        } else if (check[c - '1']) {
            return false;
        }
        check[c - '1'] = true;
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9) {
            return false;
        }
        boolean check[] = new boolean[9];
        for (int i = 0; i < 9; i ++) {
            Arrays.fill(check, false); // check row
            for (int j = 0; j < 9; j ++) {
                if (!check(check, board[i][j])) {
                    return false;
                }
            }
            Arrays.fill(check, false); // check column
            for (int j = 0; j < 9; j ++) {
                if (!check(check, board[j][i])) {
                    return false;
                }
            }
            Arrays.fill(check, false); // check 3x3
            for (int j = 0; j < 9; j ++) {
                if (!check(check, board[i - i % 3 + j / 3][i * 3 % 9 + j % 3])) {
                    return false;
                }
            }
        }
        return true;
    }
}
