/**
 * Solution.java
 * @author leo
 * @date 2013-4-3
 */
package old.q05x.q054_jump_game;

/**
 * <pre>
 * Jump Game
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * 
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    public static void  main(String [] args) {
        Solution s = new Solution();
        System.out.println(s.canJump(new int[]{2,3,1,1,4}));
    }

    public boolean canJump(int[] A) {
        if (A == null || A.length < 2) {
            return true;
        }
        int head = 0, tail = 0;
        while (head < A.length - 1) {
            int newHead = head;
            for (int i = tail; i <= head; i ++) {
                if (A[i] == 0) {
                    continue;
                }
                if (A[i] + i > newHead) {
                    newHead = A[i] + i;
                }
            }
            if (newHead == head) {
                return false;
            }
            tail = head + 1;
            head = newHead;
        }
        return true;
    }
}
