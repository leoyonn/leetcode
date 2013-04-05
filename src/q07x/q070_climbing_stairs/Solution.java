/**
 * Solution.java
 * @author leo
 * @date 2013-4-5
 */
package q07x.q070_climbing_stairs;

/**
 * <pre>
 * Climbing Stairs 432 / 861
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int a = 2, b = 1;
        while (--n > 1) {
            int c = a + b;
            b = a;
            a = c;
        }
        return a;
    }
}
