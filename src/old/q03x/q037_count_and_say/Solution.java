/**
 * Solution.java
 * @author leo
 * @date 2013-4-3
 */
package old.q03x.q037_count_and_say;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * Count and Say
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * 
 * Note: The sequence of integers will be represented as a string.
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    public static void main(String [] args) {
        Solution s = new Solution();
        System.out.println(s.countAndSay(1));
        System.out.println(s.countAndSay(2));
        System.out.println(s.countAndSay(3));
        System.out.println(s.countAndSay(10));
    }
    private StringBuilder buf = new StringBuilder();
    private Map<Integer, String> cache = new HashMap<Integer, String>();
    private int sofar = 1;

    private String cas(int idx, int n) {
        // use cache
        if (sofar >= n) {
            return cache.get(n);
        }
        // use cached prefix
        if (idx <= sofar) {
            return cas(sofar + 1, n);
        }
        // now sofar + 1 == idx, compute and add into cache
        String last = cache.get(sofar);
        buf.setLength(0);
        char[] s = last.toCharArray();
        int i, j;
        for (i = 0; i < s.length; i = j) {
            char c = s[i];
            for (j = i + 1; j < s.length && s[j] == c; j ++); 
            buf.append((char)((j - i) + '0')).append(c);
        }
        cache.put(++sofar, buf.toString());
        return cas(idx + 1, n);
    }

    public String countAndSay(int n) {
        cache.put(1, "1");
        return cas(1, n);
    }
}
