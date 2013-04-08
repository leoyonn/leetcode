/**
 * Solution.java
 * @author leo
 * @date 2013-3-21
 */
package q01x.q015_3_sum;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>
 * 3Sum 762 / 2926
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ? b ? c)
 * The solution set must not contain duplicate triplets.
 *     For example, given array S = {-1 0 1 2 -1 -4},
 *     A solution set is:
 *     (-1, 0, 1)
 *     (-1, -1, 2)
 * </pre>
 * 
 * @author leo
 */
public class Solution {
	public static void main(String [] args) {
		Solution s = new Solution();
		System.out.println(s.threeSum(new int[]{1, -2, 1}));
	}

	private void add(ArrayList<ArrayList<Integer>> res, int vi, int vj, int vk) {
		ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(vi);
		l.add(vj);
		l.add(vk);
		res.add(l);
	}

	public ArrayList<ArrayList<Integer>> threeSum (int[] num) {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	if (num == null || num.length < 3) {
    		return res;
    	}
    	Arrays.sort(num);
    	for (int i = 0; i < num.length; i ++) {
    		if (i > 0 && num[i] == num[i - 1]) {
    			continue;
    		}
    		int expect = -num[i];
    		for (int j = i + 1, k = num.length - 1; j < k;) {
    			int infact = num[j] + num[k]; 
    			if (infact == expect) {
    				add(res, num[i], num[j], num[k]);
    				while(j < k && num[j] == num[j + 1]) {
    					j ++;
    				}
    				while(j < k && num[k] == num[k - 1]) {
    					k --;
    				}
    				j ++;
    				k --;
    			} else if (infact < expect) {
    				j ++;
    			} else {
    				k --;
    			}
    		}
    	}
		return res;
    }

}
