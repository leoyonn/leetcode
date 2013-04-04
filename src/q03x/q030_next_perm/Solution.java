/**
 * Solution.java
 * @author leo
 * @date 2013-4-1
 */
package q03x.q030_next_perm;

import java.util.Arrays;

/**
 * <pre>
 * <b>Next Permutation</b>
 * Implement next permutation, which rearranges numbers into the lexicographically next greater
 * permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order
 * (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are 
 * in the right-hand column.
 * 1,2,3 ¡ú 1,3,2
 * 3,2,1 ¡ú 1,2,3
 * 1,1,5 ¡ú 1,5,1
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    public static void main(String [] args) {
        Solution s = new Solution();
        int[] a = new int[] {
            4, 2, 0, 2, 3, 2, 0
        };
        s.nextPermutation(a);
        System.out.println(Arrays.toString(a));
    }

    public void nextPermutation(int[] num) {
        if (num == null || num.length < 2) {
            return;
        }
        int i = num.length - 1;
        for (;i > 0 && num[i] <= num[i - 1]; i--);
        if (i != 0) {
            int idx = binFindLeastGt(num, i, num.length - 1, num[i - 1]);
            swap(num, idx, i - 1);
        }
        reverse(num, i, num.length - 1);
    }

    private void swap(int[]a, int i, int j) {
        a[i] ^= a[j];
        a[j] ^= a[i];
        a[i] ^= a[j];
    }

    /**
     * find the least great than v, a is descending order.
     * @param a
     * @param l
     * @param r
     * @param v
     * @return
     */
    private int binFindLeastGt(int[]a, int l, int r, int v) {
        while (l < r) {
            int m = (l + r) / 2;
            if (a[m] > v) {
                if (a[m + 1] <= v) {
                    return m;
                } else {
                    l = m + 1;
                }
            } else if (a[m] <= v) {
                r = m - 1;
            }
        }
        return l;
    }
    
    private void reverse(int []a, int l, int r) {
        while (l < r) {
            swap(a, l, r);
            l ++; r --;
        }
    }
}
 