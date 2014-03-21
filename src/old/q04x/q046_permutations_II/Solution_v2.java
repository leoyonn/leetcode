/**
 * Solution.java
 * @author leo
 * @date 2013-4-3
 */
package old.q04x.q046_permutations_II;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>
 * Permutations II
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * 
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 * </pre>
 * 
 * @author leo
 */
public class Solution_v2 {
    public static void  main(String [] args) {
        Solution_v2 s = new Solution_v2();
        System.out.println(s.permuteUnique(new int[]{1,1}));
    }

    private ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> buf = new ArrayList<Integer>();
    
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        if (num == null || num.length == 0) {
            return res;
        }
        res.clear();
        Arrays.sort(num);
        boolean[] used = new boolean[num.length];
        perm(num, 0, used);
        return res;
    }
    
    private void perm(int[] num, int i, boolean[] used) {
        if (i == num.length) {
            res.add(new ArrayList<Integer>(buf));
            return;
        }
        for (int j = 0; j < num.length; j ++) {
            if (used[j]) {
                continue;
            }
            if (j == 0 || num[j] != num[j - 1] || used[j - 1]) {
                buf.add(num[j]);
                used[j] = true;
                perm(num, i + 1, used);
                used[j] = false;
                buf.remove(i);
            }
        }
    }
}
