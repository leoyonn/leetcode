/**
 * Solution.java
 * @author leo
 * @date 2013-4-3
 */
package q038_combine_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 * Combination Sum
 * Given a set of candidate numbers (C) and a target number (T),
 *  find all unique combinations in C where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, �?, ak) must be in non-descending order. (ie, a1 ? a2 ? �?? ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 2,3,6,7 and target 7, 
 * A solution set is: 
 * [7] 
 * [2, 2, 3]  *
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    public static void main(String [] args) {
        Solution s = new Solution();
        System.out.println(s.combinationSum(new int[]{3,2,8}, 18));
    }

    private ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    private List<Integer> buf = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        res.clear();
        buf.clear();
        Arrays.sort(candidates);
        combine(candidates, 0, target);
        return res;
    }

    private void combine(int[] can, int idx, int tar) {
        if (tar == 0) {
            res.add(new ArrayList<Integer>(buf));
            return;
        } else if (idx == can.length) {
            return;
        }
        combine(can, idx + 1, tar);
        int size = buf.size();
        while ((tar -= can[idx]) >= 0) {
            buf.add(can[idx]);
            combine(can, idx + 1, tar);
        }
        size = buf.size() - size;
        while (size-- > 0) {
            buf.remove(buf.size() - 1);
        }
    }
}
