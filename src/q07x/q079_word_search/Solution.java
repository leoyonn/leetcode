/**
 * Solution.java
 * @author leo
 * @date 2013-4-6
 */
package q07x.q079_word_search;


/**
 * <pre>
 * Word Search 387 / 1383
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell,
 *  where "adjacent" cells are those horizontally or vertically neighboring.
 *  The same letter cell may not be used more than once.
 * 
 * For example,
 * Given board =
 * 
 * [
 *   ["ABCE"],
 *   ["SFCS"],
 *   ["ADEE"]
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) {
            return true;
        } else if (board == null || board.length == 0
                || board.length * board[0].length < word.length()) {
            return false;
        }
        int m = board.length, n = board[0].length;
        boolean[][] used = new boolean[m][n];
        char[] w = word.toCharArray();
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (find(board, used, i, j, w, 0)) return true;
            }
        }
        return false;
    }
    
    private boolean find(char[][]b, boolean[][]used, int i, int j, char[]w, int idx) {
        if (b[i][j] != w[idx]) {
            return false;
        } else if (idx == w.length - 1) {
            return true;
        }
        used[i][j] = true;
        if (i > 0                   && !used[i - 1][j] && find(b, used, i - 1, j, w, idx + 1)) return true;
        if (i < used.length - 1     && !used[i + 1][j] && find(b, used, i + 1, j, w, idx + 1)) return true;
        if (j > 0                   && !used[i][j - 1] && find(b, used, i, j - 1, w, idx + 1)) return true;
        if (j < used[i].length - 1  && !used[i][j + 1] && find(b, used, i, j + 1, w, idx + 1)) return true;
        used[i][j] = false;
        return false;
    }
}
