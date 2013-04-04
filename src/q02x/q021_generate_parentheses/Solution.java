/**
 * Solution.java
 * @author leo
 * @date 2013-3-30
 */
package q02x.q021_generate_parentheses;

import java.util.ArrayList;

/**
 * @author leo
 */
public class Solution {
    public static void main(String[]args) {
        Solution s = new Solution();
        System.out.println(s.generateParenthesis(1));
        System.out.println(s.generateParenthesis(2));
        System.out.println(s.generateParenthesis(3));
    }
    private ArrayList<String> res = new ArrayList<String>();
    public ArrayList<String> generateParenthesis(int n) {
        res.clear();
        if (n == 0) {
            return res;
        } else if (n == 1) {
            res.add("()");
            return res;
        }
        char[] buf = new char[2 * n];
        gen(buf, n, n);
        return res;
    }
    
    private void gen(char[] buf, int l, int r) {
        if (l == 0 && r == 0) {
            res.add(String.valueOf(buf));
            return;
        }
        if (l > 0) {
            buf[buf.length - (l + r)] = '(';
            gen(buf, l - 1, r);
        }
        if (l < r) {
            buf[buf.length - (l + r)] = ')';
            gen(buf, l, r - 1);
        }
    }
}
