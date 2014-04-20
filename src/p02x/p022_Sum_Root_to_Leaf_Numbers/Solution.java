/**
 * Solution.java
 * @author leo
 * @date 2014-3-13
 */
package p02x.p022_Sum_Root_to_Leaf_Numbers;


import java.util.Stack;

/**
 * <pre>
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 *
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 *
 * Find the total sum of all root-to-leaf numbers.
 *
 * For example,
 *
 * 1
 * / \
 * 2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 *
 * Return the sum = 12 + 13 = 25.
 * </pre>
 *
 * @author leo
 */
public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * <pre>
     * 109 / 109 test cases passed.
     * Status: Accepted
     * Runtime: 412 ms
     * Submitted: 0 minutes ago
     * </pre>
     *
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> s = new Stack<TreeNode>();
        int height = 0, sum = 0;
        TreeNode pre = null;
        while (root != null || !s.isEmpty()) {
            if (root != null) {
                s.push(root);
                height = height * 10 + root.val;
                root = root.left;
            } else if (s.peek().right != pre) {
                root = s.peek().right;
                pre = null;
            } else {
                pre = s.pop();
                if (pre.left == null && pre.right == null) {
                    sum += height;
                }
                height = (height - pre.val) / 10;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
    }
}
 