/**
 * Solution.java
 * @author leo
 * @date 2013-4-3
 */
package old.q03x.q039_combine_sum_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 * Combination Sum II
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * 
 * Each number in C may only be used once in the combination.
 * 
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, 锟�, ak) must be in non-descending order. (ie, a1 ? a2 ? 锟�? ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
 * A solution set is: 
 * [1, 7] 
 * [1, 2, 5] 
 * [2, 6] 
 * [1, 1, 6]
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    public static void main(String [] args) {
        Solution s = new Solution();
        System.out.println(s.combinationSum2(new int[]{2,2,2,8}, 4));
    }

    private ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    private List<Integer> buf = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        res.clear();
        buf.clear();
        Arrays.sort(num);
        combine(num, 0, target);
        return res;
    }

    private void combine(int[] can, int idx, int tar) {
        if (tar == 0) {
            res.add(new ArrayList<Integer>(buf));
            return;
        } else if (idx == can.length) {
            return;
        }
        int next = idx + 1;
        while (next < can.length && can[next - 1] == can[next]) {
            next ++;
        }
        combine(can, next, tar);
        int i;
        for (i = idx; i < next && tar >= can[i]; i ++) {
            buf.add(can[i]);
            combine(can, next, tar -= can[i]);
        }
        while (i-- > idx) {
            buf.remove(buf.size() - 1);
        }
    }
}
