/**
 * Solution.java
 * @author leo
 * @date 2013-4-5
 */
package old.q07x.q072_edit_distance;


/**
 * <pre>
 * Edit Distance 283 / 910
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2.
 *  (each operation is counted as 1 step.)
 * 
 * You have the following 3 operations permitted on a word:
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minDistance("abc", "abd"));
    }

    public int minDistance(String word1, String word2) {
        if (word1 == word2 || word1 != null && word1.equals(word2)) {
            return 0;
        } else if (word1 == null || word1.length() == 0) {
            return word2.length();
        } else if (word2 == null || word2.length() == 0) {
            return word1.length();
        }
        char[] w1 = word1.toCharArray(), w2 = word2.toCharArray();
        int[][] d = new int[w1.length + 1][w2.length + 1];
        for (int j = 0; j <= w2.length; j ++) {
            d[0][j] = j;
        }
        for (int i = 1; i <= w1.length; i ++) {
            d[i][0] = i;
            for (int j = 1; j <= w2.length; j ++) {
                d[i][j] = d[i - 1][j - 1];
                if (w1[i - 1] != w2[j - 1]) {
                    int min = Math.min(d[i][j - 1], d[i - 1][j]);
                    d[i][j] = Math.min(d[i][j], min) + 1;
                }
            }
        }
        return d[w1.length][w2.length];
    }
}
