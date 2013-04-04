/**
 * Solution.java
 * @author leo
 * @date 2013-4-3
 */
package q04x.q046_permutations_II;

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
public class Solution_v3 {
    public static void  main(String [] args) {
        Solution_v3 s = new Solution_v3();
        System.out.println(s.permuteUnique(new int[]{0,0,1,1}));
    }

    private ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    private int[] buf;
    
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        if (num == null || num.length == 0) {
            return res;
        }
        res.clear();
        Arrays.sort(num);
        boolean[] filled = new boolean[num.length];
        buf = new int[num.length];
        perm(num, 0, -1, filled);
        return res;
    }
    
    private void perm(int[] num, int i, int lastPos, boolean[] filled) {
        if (i == num.length) {
            ArrayList<Integer> solution = new ArrayList<Integer>(buf.length);
            for (int n: buf) {
                solution.add(n);
            }
            res.add(solution);
            return;
        }
        int start = i == 0 || num[i] != num[i - 1] ? 0 : lastPos + 1;
        for (int j = start; j < num.length; j ++) {
            if (!filled[j]) {
                filled[j] = true;
                buf[j] = num[i];
                perm(num, i + 1, j, filled);
                filled[j] = false;
            }
        }
    }
}
