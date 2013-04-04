/**
 * Solution.java
 * @author leo
 * @date 2013-4-3
 */
package q04x.q046_permutations_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
public class Solution_v1 {
    public static void  main(String [] args) {
        Solution_v1 s = new Solution_v1();
        System.out.println(s.permuteUnique(new int[]{0,0,1,1}));
    }

    private ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        if (num == null || num.length == 0) {
            return res;
        }
        res.clear();
        Arrays.sort(num);
        perm(num, 0);
        return res;
    }
    
    private void perm(int[] num, int i) {
        if (i == num.length - 1) {
            ArrayList<Integer> solution = new ArrayList<Integer>(num.length);
            for (int n: num) {
                solution.add(n);
            }
            res.add(solution);
            return;
        }
        perm(num, i + 1);
        Set<Integer> used = new HashSet<Integer>();
        used.add(num[i]);
        for (int j = i + 1; j < num.length; j ++) {
            if (!used.contains(num[j])) {
                swap(num, i, j);
                perm(num, i + 1);
                swap(num, i, j);
                used.add(num[j]);
            }
        }
    }
    
    private void swap(int[] a, int i, int j) {
        a[i] ^= a[j];
        a[j] ^= a[i];
        a[i] ^= a[j];
    }
}
