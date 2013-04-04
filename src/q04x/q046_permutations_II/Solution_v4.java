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
public class Solution_v4 {
    public static void  main(String [] args) {
        Solution_v4 s = new Solution_v4();
        System.out.println(s.permuteUnique(new int[]{0,0,1,1}));
    }

    private ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        if (num == null || num.length == 0) {
            return res;
        }
        res.clear();
        Arrays.sort(num);
        while(nextPerm(num));
        return res;
    }
    
    private boolean nextPerm(int[] num) {
        ArrayList<Integer> solution = new ArrayList<Integer>(num.length);
        for (int n: num) {
            solution.add(n);
        }
        res.add(solution);
        int i, j;
        for (i = num.length - 2; i >= 0 && num[i + 1] <= num[i]; i--);
        if (i < 0) {
            return false;
        }
        for (j = num.length - 1; j > i; j --) {
            if (num[j] > num[i]) {
                break;
            }
        }
        swap(num, i, j);
        // reverse
        for (++i, j = num.length - 1; i < j; i++, j--) {
            swap(num, i, j);
        }
        return true;
    }
    
    private void swap(int[]a, int i, int j) {
        a[i] ^= a[j];
        a[j] ^= a[i];
        a[i] ^= a[j];
    }
}
