/**
 * Solution.java
 * @author leo
 * @date 2013-4-6
 */
package q08x.q088_merge_sorted_array;




/**
 * <pre>
 * Merge Sorted Array 440 / 1005
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * Note:
 * You may assume that A has enough space to hold additional elements from B. 
 * The number of elements initialized in A and B are m and n respectively.
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        if (n == 0) {
            return;
        }
        int idx = m + n - 1;
        for (int i = m - 1, j = n - 1; i >= 0 || j >= 0; idx --) {
            A[idx] = i < 0 ? B[j--] : j < 0 ? A[i--] : A[i] <= B[j] ? B[j--] : A[i--];
        }
    }
}
