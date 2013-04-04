/**
 * Solution.java
 * @author leo
 * @date 2013-4-3
 */
package q04x.q049_power_x_n;

/**
 * <pre>
 * Pow(x, n)
 * Implement pow(x, n).
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    public static void  main(String [] args) {
        Solution s = new Solution();
        System.out.println(s.pow(1.1, 2));
    }
    
    public double pow(double x, int n) {
        double r = 1, p = x;
        boolean inv = false;
        if (n < 0) {
            n = -n;
            inv = true;
        }
        while (n > 0) {
            if ((n & 1) == 1) {
                r *= p;
            }
            p *= p;
            n >>= 1;
        }
        return inv ? 1 / r : r;
    }
}