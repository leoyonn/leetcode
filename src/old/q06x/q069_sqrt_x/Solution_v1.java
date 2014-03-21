/**
 * Solution.java
 * @author leo
 * @date 2013-3-31
 */
package old.q06x.q069_sqrt_x;





/**
 * <pre>
 * Sqrt(x) 496 / 2018
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x.
 * </pre>
 * 
 * @author leo
 */
public class Solution_v1 {
    public static void main(String[] args) {
        System.out.println(new Solution_v1().sqrt(2147395599));
    }

    public int sqrt(int x) {
        if (x == 0) {
            return 0;
        } else if (x < 4) {
            return 1;
        }
        long l = 1, r = x >> 1, m;
        while (l <= r) {
            m = (l + r) >> 1;
            long y = m * m;
            if (y > x) {
                r = m - 1;
            } else if (y < x) {
                l = m + 1;
            } else {
                return (int)m;
            }
        }
        return (int)r;
    }
}
