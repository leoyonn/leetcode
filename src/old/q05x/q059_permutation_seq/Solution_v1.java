/**
 * Solution.java
 * @author leo
 * @date 2013-4-3
 */
package old.q05x.q059_permutation_seq;




/**
 * <pre>
 * Permutation Sequence 149 / 579
 * The set [1,2,3,��,n] contains a total of n! unique permutations.
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
public class Solution_v1 {
    public static void  main(String [] args) {
        Solution_v1 s = new Solution_v1();
        System.out.println(s.getPermutation(3, 4));
    }

    public String getPermutation(int n, int k) {
        char[] s = new char[n];
        int fact = 1;
        for (int i = 0; i < n; i ++) {
            fact *= (i + 1);
            s[i] = (char) ('1' + i);
        }
        k = (k - 1) % fact;
        for (int i = 0; i < n && k > 0; i ++) {
            fact /= (n - i);
            int first = k / fact;
            k -= fact * first;
            if (first != 0) {
                char c = s[first + i];
                for (int j = first + i; j > i; j--) {
                    s[j] = s[j - 1];
                }
                s[i] = c;
            }
        }
        return String.valueOf(s);
    }
}
