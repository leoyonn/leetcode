/**
 * Solution.java
 * @author leo
 * @date 2013-4-6
 */
package old.q08x.q087_scramble_string;




/**
 * <pre>
 * Scramble String 275 / 769
 * Given a string s1, we may represent it as a binary tree by partitioning it to 
 * two non-empty substrings recursively.
 * 
 * Below is one possible representation of s1 = "great":
 *     great
 *    /    \
 *   gr    eat
 *  / \    /  \
 * g   r  e   at
 *            / \
 *           a   t
 * To scramble the string, we may choose any non-leaf node and swap its two children.
 * For example, if we choose the node "gr" and swap its two children, 
 * it produces a scrambled string "rgeat".
 *     rgeat
 *    /    \
 *   rg    eat
 *  / \    /  \
 * r   g  e   at
 *            / \
 *           a   t
 * We say that "rgeat" is a scrambled string of "great".
 * Similarly, if we continue to swap the children of nodes "eat" and "at", 
 * it produces a scrambled string "rgtae".
 *     rgtae
 *    /    \
 *   rg    tae
 *  / \    /  \
 * r   g  ta  e
 *        / \
 *       t   a
 * We say that "rgtae" is a scrambled string of "great".
 * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isScramble("abcd", "bdac"));
    }

    public boolean isScramble(String str1, String str2) {
        if (str1.equals(str2)) {
            return true;
        } else if (str1.length() != str2.length()) {
            return false;
        }
        char[] s1 = str1.toCharArray(), s2 = str2.toCharArray();
        return scramble(s1, 0, s2, 0, s1.length);
    }
    
    private boolean scramble(char[] s1, int start1, char[] s2, int start2, int len) {
        if (len == 1) {
            return s1[start1] == s2[start2];
        }
        // use 'hash' to cut off illegal cases.
        int hash1l = 0, hash2l = 0, hash2r = 0;
        for (int i = 0; i < len - 1; i ++) {
            hash1l += s1[start1 + i];
            hash2l += s2[start2 + i];
            hash2r += s2[start2 + len - i - 1];
            int lenl = i + 1, lenr = len - lenl;
            // no rotate
            if (hash1l == hash2l && scramble(s1, start1, s2, start2, lenl)
                    && scramble(s1, start1 + lenl, s2, start2 + lenl, lenr)) {
                return true;
            }
            // rotate
            if (hash1l == hash2r && scramble(s1, start1, s2, start2 + lenr, lenl)
                    && scramble(s1, start1 + lenl, s2, start2, lenr)) {
                return true;
            }
        }
        return false;
    }
}
