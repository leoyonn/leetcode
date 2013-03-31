/**
 * Solution.java
 * @author leo
 * @date 2013-3-31
 */
package q028_divide;

/**
 * @author leo
 */
public class Solution {
	public static void main(String [] args) {
		Solution s = new Solution();
        System.out.println(s.divide(1, 10));
        System.out.println(s.divide(10, 1));
        System.out.println(s.divide(10, 10));
        System.out.println(s.divide(100, 9));
        System.out.println(s.divide(3, -2));
	}

    public int divide(int dividend, int divisor) {
        long a = dividend, b = divisor;
        if (a == 0 || b == 0) {
            return 0;
        }
        int sign = 1;
        if (a < 0) {
            a = -a;
            sign = -sign;
        }
        if (b < 0) {
            b = - b;
            sign = -sign;
        }
        if (a < b) {
            return 0;
        } else if (b == 1) {
            return sign * (int)a;
        }
        int ans = 0;
        while (a >= b) {
            int i = 1;
            while ((b << i) <= a) {
                i ++;
            }
            i --;
            ans += 1 << i;
            a -= b << i;
        }
        
        return sign * ans;
    }
}
