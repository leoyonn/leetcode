/**
 * Solution.java
 * @author leo
 * @date 2013-4-6
 */
package old.q07x.q077_combinations;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>
 * Combinations 366 / 848
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * 
 * For example,
 * If n = 4 and k = 2, a solution is:
 * 
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>(); 
    ArrayList<Integer> buf = new ArrayList<Integer>(); 
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        if (n == 0 || k == 0) {
            return res;
        }
        res.clear();
        buf.clear();
        boolean[] used = new boolean[n];
        Arrays.fill(used, false);
        comb(0, k, used);
        return res;
    }
    
    private void comb(int idx, int k, boolean[] used) {
        if (idx == k) {
            res.add(new ArrayList<Integer>(buf));
            return;
        }
        int start = buf.size() == 0 ? 0 : buf.get(buf.size() - 1);
        if (used.length - start < k - idx) {
            return;
        }
        for (int i = start; i < used.length; i ++) {
            if (!used[i]) {
                buf.add(i + 1);
                used[i] = true;
                comb(idx + 1, k, used);
                used[i] = false;
                buf.remove(buf.size() - 1);
            }
        }
    }
}
