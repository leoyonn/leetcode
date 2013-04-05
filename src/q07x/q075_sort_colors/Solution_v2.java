/**
 * Solution.java
 * @author leo
 * @date 2013-4-6
 */
package q07x.q075_sort_colors;

import java.util.Arrays;

/**
 * <pre>
 * Sort ColorsApr 9 '12335 / 830
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
public class Solution_v2 {
    public void sortColors(int[] A) {
        int[] c = new int[3];
        for (int i = 0; i < A.length; i ++) {
            c[A[i]] ++;
        }
        Arrays.fill(A, 0, c[0], 0);
        Arrays.fill(A, c[0], c[1], 1);
        Arrays.fill(A, c[1], c[2], 2);
    }
}
