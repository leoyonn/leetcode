/**
 * Solution.java
 * @author leo
 * @date 2013-3-21
 */
package old.q00x.q009_palindrome_number;

/**
 * <pre>
 * Palindrome Number 624 / 1582
 * Determine whether an integer is a palindrome. Do this without extra space.
 * </pre>
 * 
 * @author leo
 */
public class Solution {
	public static void main(String [] args) {
		Solution s = new Solution();
		System.out.println(s.isPalindrome(0));
		System.out.println(s.isPalindrome(1));
		System.out.println(s.isPalindrome(121));
		System.out.println(s.isPalindrome(1221));
		System.out.println(s.isPalindrome(-2323));
		System.out.println(s.isPalindrome(-23232));
		System.out.println(s.isPalindrome(-2147447412));
	}

	public boolean isPalindrome(int x) {
    	if (x < 0) {
    		return false;
    	} else if (x < 10) {
    		return true;
    	}
    	long powerl = 1;
    	while (powerl <= x) {
    		powerl *= 10;
    	}
    	int power = (int) (powerl / 10);
    	int first = x / power, last = x % 10;
    	while (first == last && x > 10) {
    		x = (x - first * power) / 10;
    		if (x < 10) {
    			break;
    		}
    		power /= 100;
    		first = x / power;
    		last = x % 10;
    	}
        return first == last;
    }
}