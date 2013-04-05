/**
 * Solution.java
 * @author leo
 * @date 2013-3-31
 */
package q06x.q069_sqrt_x;





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
public class Solution_v2 {
    public static void main(String[] args) {
        System.out.println(new Solution_v2().sqrt(2147395599));
    }

    public int sqrt(int x) {
        if (x == 0) {
            return 0;
        } else if (x < 4) {
            return 1;
        }
        double y = x / 2, lasty = x;
        double e = 0.001;
        while (lasty - y > e) {
            lasty = y;
            y = (y + x / y) / 2;
        }
        return (int)y;
    }
}
