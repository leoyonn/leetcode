/**
 * Solution.java
 * @author leo
 * @date 2013-3-31
 */
package old.q02x.q026_remove_element;

/**
 * <pre>
 * Remove Element 476 / 931
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * </pre>
 * 
 * @author leo
 */
public class Solution {
	public static void main(String [] args) {
		Solution s = new Solution();
        System.out.println(s.removeElement(new int[]{1}, 1));
        System.out.println(s.removeElement(new int[]{1, 1}, 1));
        System.out.println(s.removeElement(new int[]{1, 1, 1}, 1));
        System.out.println(s.removeElement(new int[]{1, 1, 2, 4}, 2));
	}

    public int removeElement(int[] A, int elem) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int i = 0, j = 0;
        for (; j < A.length; j ++) {
            if (A[j] == elem) {
                continue;
            }
            if (i != j) {
                A[i] = A[j];
            }
            i ++;
        }
        return i;
    }
}
