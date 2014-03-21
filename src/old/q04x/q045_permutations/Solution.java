/**
 * Solution.java
 * @author leo
 * @date 2013-4-3
 */
package old.q04x.q045_permutations;

import java.util.ArrayList;

/**
 * <pre>
 * Permutations
 * Given a collection of numbers, return all possible permutations.
 * 
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    public static void  main(String [] args) {
        Solution s = new Solution();
        System.out.println(s.permute(new int[]{1,2,3}));
    }

    private ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        if (num == null || num.length == 0) {
            return res;
        }
        res.clear();
        perm(num, 0);
        return res;
    }
    
    private void perm(int[] num, int i) {
        if (i == num.length) {
            ArrayList<Integer> solution = new ArrayList<Integer>(num.length);
            for (int n: num) {
                solution.add(n);
            }
            res.add(solution);
            return;
        }
        perm(num, i + 1);
        for (int j = i + 1; j < num.length; j ++) {
            swap(num, i, j);
            perm(num, i + 1);
            swap(num, i, j);
        }
    }
    
    private void swap(int[] a, int i, int j) {
        a[i] ^= a[j];
        a[j] ^= a[i];
        a[i] ^= a[j];
    }
}
