/**
 * Solution.java
 * @author leo
 * @date 2013-3-21
 */
package old.q01x.q016_3_sum_closet;

import java.util.Arrays;

/**
 * <pre>
 * 3Sum Closest 415 / 1027
 * Given an array S of n integers, find three integers in S such that the sum is closest to 
 * a given number, target. Return the sum of the three integers. 
 * You may assume that each input would have exactly one solution.
 *     For example, given array S = {-1 2 1 -4}, and target = 1.
 *     The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * </pre>
 * 
 * @author leo
 */
public class Solution {
	public static void main(String [] args) {
		Solution s = new Solution();
		System.out.println(s.threeSumClosest(new int[]{1, -2, 1, 1}, 4));
	}

    public int threeSumClosest(int[] num, int target) {
    	if (num == null || num.length == 0) {
    		return 0;
    	} else if (num.length == 1) {
    		return num[0];
    	} else if (num.length == 2) {
    		return num[0] + num[1];
    	} else if (num.length == 3) {
    		return num[0] + num[1] + num[2];
    	}
    	Arrays.sort(num);
		int mind = Integer.MAX_VALUE, closet = 0;
    	for (int i = 0; i < num.length; i ++) {
    		if (i > 0 && num[i] == num[i - 1]) {
    			continue;
    		}
    		int expect = target - num[i];
    		for (int j = i + 1, k = num.length - 1; j < k;) {
    			int infact = num[j] + num[k]; 
    			if (infact == expect) {
    				return target;
    			}
    			int d = Math.abs(infact - expect);
    			if (d < mind) {
    				mind = d;
    				closet = infact - expect + target;
    			}
    			if (infact < expect) {
    				j ++;
    			} else {
    				k --;
    			}
    		}
    	}
		return closet;
    }

}
