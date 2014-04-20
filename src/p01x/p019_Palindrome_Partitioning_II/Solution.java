/**
 * Solution.java
 * @author leo
 * @date 2014-3-13
 */
package p01x.p019_Palindrome_Partitioning_II;


/**
 * <pre>
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * For example, given s = "aab",
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * </pre>
 *
 * @author leo
 */
public class Solution {
    public int minCut(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        char[] arr = s.toCharArray();
        int N = arr.length;
        // p[i][j] == true if arr[i->j] is a palindrome.
        boolean p[][] = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            p[i][i] = true;
        }
        // min cut from i to N. returns min[0].
        int min[] = new int[N + 1];
        for (int i = N; i >= 0; i--) {
            min[i] = N - i;
        }
        for (int i = N - 2; i >= 0; i--) {
            for (int j = i; j < N; j++) {
                if (arr[i] == arr[j] && (j - i <= 2 || p[i + 1][j - 1])) {
                    p[i][j] = true;
                    min[i] = Math.min(min[i], min[j + 1] + 1);
                }
            }
        }
        return min[0] - 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minCut("baacaac"));
    }
}
 