/**
 * Solution.java
 * @author leo
 * @date 2013-4-3
 */
package old.q04x.q044_jump_game_II;

/**
 * <pre>
 * Jump Game II
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * For example:
 * Given array A = [2,3,1,1,4]
 * 
 * The minimum number of jumps to reach the last index is 2.
 *  (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    public static void  main(String [] args) {
        Solution s = new Solution();
        System.out.println(s.jump(new int[]{2,3,1,1,4}));
    }

    public int jump(int[] A) {
        if (A == null || A.length < 2) {
            return 0;
        }
        int step = 0, head = 0, tail = 0;
        while (head < A.length - 1) {
            step ++;
            int newHead = head;
            for (int i = tail; i <= head; i ++) {
                if (A[i] + i > newHead) {
                    newHead = A[i] + i;
                }
            }
            tail = head + 1;
            head = newHead;
        }
        return step;
    }
}
