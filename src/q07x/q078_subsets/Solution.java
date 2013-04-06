/**
 * Solution.java
 * @author leo
 * @date 2013-4-6
 */
package q07x.q078_subsets;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>
 * Subsets 360 / 978
 * Given a set of distinct integers, S, return all possible subsets.
 * 
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,3], a solution is:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
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
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        if (S == null || S.length == 0) {
            return res;
        }
        Arrays.sort(S);
        res.clear();
        buf.clear();
        buf.ensureCapacity(S.length);
        comb(S, 0);
        return res;
    }
    
    private void comb(int[]s, int i) {
        if (i == s.length) {
            res.add(new ArrayList<Integer>(buf));
            return;
        }
        comb(s, i + 1);
        buf.add(s[i]);
        comb(s, i + 1);
        buf.remove(buf.size() - 1);
    }
}
