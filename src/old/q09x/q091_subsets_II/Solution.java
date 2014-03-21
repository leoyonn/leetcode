/**
 * Solution.java
 * @author leo
 * @date 2013-4-6
 */
package old.q09x.q091_subsets_II;

import java.util.ArrayList;
import java.util.Arrays;





/**
 * <pre>
 * Subsets II 315 / 895
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.
 * 
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,2], a solution is:
 * 
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> buf = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        res.clear();
        if (num == null || num.length == 0) {
            return res;
        }
        buf.clear();
        Arrays.sort(num);
        subsets(num, new boolean[num.length], 0);
        return res;
    }
    
    private void subsets(int[] num, boolean[] used, int idx) {
        if (idx == num.length) {
            res.add(new ArrayList<Integer>(buf));
            return;
        }
        subsets(num, used, idx + 1);
        if (idx != 0 && num[idx] == num[idx - 1] && !used[idx - 1]) {
            return;
        }
        used[idx] = true;
        buf.add(num[idx]);
        subsets(num, used, idx + 1);
        used[idx] = false;
        buf.remove(buf.size() - 1);
    }
}
