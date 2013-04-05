/**
 * Solution.java
 * @author leo
 * @date 2013-4-3
 */
package q05x.q059_permutation_seq;




/**
 * <pre>
 * Permutation SequenceMar 28 '12149 / 579
 * The set [1,2,3,бн,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * 
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * 
 * Note: Given n will be between 1 and 9 inclusive.
 * </pre>
 * 
 * @author leo
 */
public class Solution_v2 {
    public static void  main(String [] args) {
        Solution_v2 s = new Solution_v2();
        System.out.println(s.getPermutation(3, 6));
    }

    private StringBuilder buf = new StringBuilder();
    private int fact;
    public String getPermutation(int n, int k) {
        boolean[] used = new boolean[n];
        buf.setLength(0);
        fact = 1;
        for (int i = 2; i <= n; i ++) {
            fact *= i;
        }
        perm(n, k - 1, used);
        return buf.toString();
    }
    
    private void perm(int n, int k, boolean[] used) {
        // got it
        if (k == 0) {
            for (int i = 0; i < used.length; i ++) {
                if (!used[i]) {
                    buf.append(i + 1);
                }
            }
            return;
        }
        // find first bit of perm:
        fact /= n;
        int first = k / fact;
        k -= first * fact;
        for (int i = 0; i < used.length; i ++) {
            if (!used[i] && first-- == 0) {
                buf.append(i + 1);
                used[i] = true;
                break;
            }
        }
        perm(n - 1, k, used);
    }
}
