/**
 * Solution.java
 * @author leo
 * @date 2014-3-13
 */
package p00x.p006_Binary_Tree_Postorder_Traversal;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <pre>
 * Given a binary tree, return the postorder traversal of its nodes' values.
 *
 * For example:
 * Given binary tree {1,#,2,3},
 * 1
 *  \
 *   2
 *  /
 * 3
 * return [3,2,1].
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
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
     * 67 / 67 test cases passed.
     * Status: Accepted
     * Runtime: 340 ms
     *
     * @param root
     * @return
     */
    public ArrayList<Integer> postorderTraversal1(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        postTrav(result, root);
        return result;
    }

    private void postTrav(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }
        postTrav(result, root.left);
        postTrav(result, root.right);
        result.add(root.val);
    }

    /**
     * 67 / 67 test cases passed.
     * Status: Accepted
     * Runtime: 388 ms
     *
     * @param root
     * @return
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null, cur = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            cur = stack.peek();
            if (pre == null || pre.left == cur || pre.right == cur) {
                if (cur.left != null) {
                    stack.push(cur.left);
                } else if (cur.right != null) {
                    stack.push(cur.right);
                } else {
                    result.add(stack.pop().val);
                }
            } else if (pre == cur.left) {
                if (cur.right == null) {
                    result.add(stack.pop().val);
                } else {
                    stack.push(cur.right);
                }
            } else if (pre == cur.right) {
                result.add(stack.pop().val);
            }
            pre = cur;
        }
        return result;
    }

    public static void main(String[] args) {
    }
}
 