/**
 * Solution.java
 * @author leo
 * @date 2013-4-6
 */
package q09x.q093_restore_ip;

import java.util.ArrayList;

/**
 * <pre>
 * Restore IP Addresses 347 / 1240
 * Given a string containing only digits, 
 * restore it by returning all possible valid IP address combinations.
 * For example:
 * Given "25525511135",
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().restoreIpAddresses("00110"));
    }
    
    ArrayList<String> res = new ArrayList<String>();
    StringBuilder buf = new StringBuilder();
    public ArrayList<String> restoreIpAddresses(String s) {
        res.clear();
        if (s == null || s.length() > 12 || s.length() < 4) {
            return res;
        }
        buf.setLength(0);
        restoreIp(s.toCharArray(), 0, 0);
        return res;
    }
    
    private void restoreIp(char[] s, int start, int seg) {
        if (start == s.length && seg == 4) {
            res.add(buf.toString());
            return;
        }
        // cut off illegal cases
        int left = s.length - start; 
        if (left < 4 - seg || left > (4 - seg) * 3) {
            return;
        }
        int oriBufLen = buf.length();
        if (seg != 0) {
            buf.append('.');
        }
        // 1 bit in this segment
        int bits = 1;
        buf.append(s[start + bits - 1]);
        restoreIp(s, start + bits, seg + 1);
        // 2 bits in this segment
        bits ++;
        if (start + bits <= s.length && s[start] != '0') {
            buf.append(s[start + bits - 1]);
            restoreIp(s, start + bits, seg + 1);
        }
        bits ++;
        // 3 bits in this segment
        if (start + bits <= s.length && s[start] != '0') {
            int v =  Integer.valueOf(String.valueOf(s, start, bits));
            if (v >= 100 && v <= 255) {
                buf.append(s[start + bits - 1]);
                restoreIp(s, start + bits, seg + 1);
            }
        }
        // back tracking
        buf.setLength(oriBufLen);
    }
}
