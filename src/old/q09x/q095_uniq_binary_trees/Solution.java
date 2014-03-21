/**
 * Solution.java
 * @author leo
 * @date 2013-4-6
 */
package old.q09x.q095_uniq_binary_trees;


/**
 * <pre>
 * Unique Binary Search Trees 355 / 684
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * 
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    public static void main(String[] args) {
    }
    
    public int numTrees(int n) {
        if (n < 2) {
            return 1;
        }
        int[] count = new int [n + 1];
        count[0] = count[1] = 1;
        for (int i = 2; i <= n; i ++) {
            for (int k = 0; k < i; k ++) {
                count[i] += count[k] * count[i - k - 1];
            }
        }
        return count[n];
    }
}
