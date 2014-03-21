/**
 * Solution.java
 * @author leo
 * @date 2013-4-2
 */
package old.q08x.q084_largest_rect_in_histogram;



/**
 * <pre>
 * Largest Rectangle in Histogram 487 / 1617
 * Given n non-negative integers representing the histogram's bar height 
 * where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * 
 * For example,
 * Given height = [2,1,5,6,2,3],
 * return 10.
 * </pre>
 * 
 * another solution:
 * http://blog.csdn.net/tingmei/article/details/8043704
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
