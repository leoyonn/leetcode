/**
 * Solution.java
 * @author leo
 * @date 2013-4-2
 */
package q08x.q085_max_rect;



/**
 * <pre>
 * Maximal Rectangle 219 / 866
 * Given a 2D binary matrix filled with 0's and 1's,
 * find the largest rectangle containing all ones and return its area.
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    public static void main(String [] args) {
        Solution s = new Solution();
        int[] a = new int[] {1,1
        };
        System.out.println(s.largestRectangleArea(a));
    }

    /**
     * simply use http://leetcode.com/onlinejudge#question_85
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[] row = new int [matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j < row.length; j ++) {
                if (matrix[i][j] == '0') {
                    row[j] = 0;
                } else {
                    row[j] ++;
                }
            }
            int rowMax = largestRectangleArea(row); 
            if (max < rowMax) {
                max = rowMax;
            }
        }
        return max;
    }

    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        } else if (height.length == 1) {
            return height[0];
        }
        // use a stack to store min-heights, collapse when new height is smaller than stack[top]
        int[] minStack = new int[height.length];
        int max = height[0], top = 0;
        minStack[0] = 0;
        for (int i = 1; i <= height.length; i ++) {
            int curHeight = i == height.length ? -1 : height[i];
            // collapse and collect max
            while (top >= 0 && height[minStack[top]] >= curHeight) {
                int width = top == 0 ? i : (i - minStack[top - 1] - 1);
                int rect = height[minStack[top]] * width;
                if (max < rect) {
                    max = rect;
                }
                top --;
            }
            // store
            minStack[++top] = i;
        }
        return max;
    }
}
