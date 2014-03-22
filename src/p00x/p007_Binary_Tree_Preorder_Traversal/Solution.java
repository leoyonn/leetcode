/**
 * Solution.java
 * @author leo
 * @date 2014-3-13
 */
package p00x.p007_Binary_Tree_Preorder_Traversal;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <pre>
 * Given a binary tree, return the preorder traversal of its nodes' values.
 *
 * For example:
 * Given binary tree {1,#,2,3},
 * 1
 * \
 * 2
 * /
 * 3
 * return [1,2,3].
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
    public ArrayList<Integer> preorderTraversal1(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        preTrav(result, root);
        return result;
    }

    private void preTrav(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preTrav(result, root.left);
        preTrav(result, root.right);
    }

    /**
     * 67 / 67 test cases passed.
     * Status: Accepted
     * Runtime: 376 ms
     *
     * @param root
     * @return
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            result.add((root = stack.pop()).val);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
        return result;
    }

    public static void main(String[] args) {
    }
}
 