/**
 * Solution.java
 * @author leo
 * @date 2013-3-21
 */
package q01x.q011_contain_most_water;

/**
 * <pre>
 * Container With Most Water 500 / 1029
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container, such that the container 
 * contains the most water.
 * 
 * Note: You may not slant the container.
 * </pre>
 * 
 * @author leo
 */
public class Solution {
	public static void main(String [] args) {
		Solution s = new Solution();
		System.out.println(s.maxArea(new int[]{}));
		System.out.println(s.maxArea(new int[]{1}));
		System.out.println(s.maxArea(new int[]{1, 1}));
		System.out.println(s.maxArea(new int[]{1, 2, 3}));
		System.out.println(s.maxArea(new int[]{2, 2, 5}));
		System.out.println(s.maxArea(new int[]{3, 4, 2, 5}));
	}
    public int maxArea(int[] height) {
    	if (height == null || height.length < 2) {
    		return 0;
    	}
    	int max = 0;
    	for (int i = 0, j = height.length - 1; i < j; ) {
    		int c;
    		if (height[i] < height[j]) {
    			c = height[i] * (j - i);
    			i ++;
    		} else {
    			c = height[j] * (j - i);
    			j --;
    		}
			if (c > max) {
				max = c;
			}
    	}
    	return max;
    }

}