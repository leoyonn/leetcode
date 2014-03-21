/**
 * Solution.java
 * @author leo
 * @date 2013-4-6
 */
package old.q07x.q075_sort_colors;

/**
 * <pre>
 * Sort Colors 335 / 830
 * Given an array with n objects colored red, white or blue,
 *  sort them so that objects of the same color are adjacent,
 *  with the colors in the order red, white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * 
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 * 
 * </pre>
 * 
 * @author leo
 */
public class Solution_v1 {
    
    public void sortColors(int[] A) {
        int i = 0, j = A.length - 1;
        while (i < j) {
            while (i < j && A[i] == 0) {
                i ++;
            }
            while (i < j && A[j] != 0) {
                j --;
            }
            if (i != j) {
                swap(A, i, j);
            }
        }
        j = A.length - 1;
        while (i < j) {
            while (i < j && A[j] == 2) {
                j --;
            }
            while (i < j && A[i] != 2) {
                i ++;
            }
            if (i != j) {
                swap(A, i, j);
            }
        }
    }
    
    private void swap(int[] A, int i, int j) {
        A[i] ^= A[j];
        A[j] ^= A[i];
        A[i] ^= A[j];
    }
}
