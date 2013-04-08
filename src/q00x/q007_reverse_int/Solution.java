/**
 * Solution.java
 * @author leo
 * @date 2013-3-21
 */
package q00x.q007_reverse_int;

/**
 * <pre>
 * Reverse IntegerDec 26 '11685 / 1224
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * </pre>
 * 
 * @author leo
 */
public class Solution {
	public static void main(String [] args) {
		Solution s = new Solution();
		System.out.println(s.reverse(1));
		System.out.println(s.reverse(10));
		System.out.println(s.reverse(123));
		System.out.println(s.reverse(-123));
	}
	
    public int reverse(int x) {
    	boolean neg = false;
    	if (x < 0) {
    		x = -x;
    		neg = true;
    	}
    	int y = 0;
    	while (x > 0) {
    		y = y * 10 + x % 10;
    		x /= 10;
    	}
    	return neg ? -y : y;
    }

}