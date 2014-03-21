/**
 * Solution.java
 * @author leo
 * @date 2013-4-6
 */
package old.q09x.q090_decode_ways;

/**
 * <pre>
 * Decode Ways 477 / 1848
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * 
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * The number of ways decoding "12" is 2.
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    public int numDecodings(String str) {
        if (str.length() < 2) {
            if (str.equals("0")) {
                return 0;
            }
            return str.length();
        }
        char[] s = str.toCharArray();
        int[] ways = new int[s.length + 1];
        ways[s.length - 1] = s[s.length - 1] == '0' ? 0 : 1;
        ways[s.length] = 1;
        for (int j = s.length - 2; j >= 0; j--) {
            if (s[j] != '0') {
                ways[j] = ways[j + 1];
            }
            if (s[j] == '1' || s[j] == '2' && s[j + 1] < '7') {
                ways[j] += ways[j + 2];
            }
        }
        return ways[0];
    }
}
