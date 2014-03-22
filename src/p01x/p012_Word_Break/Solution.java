/**
 * Solution.java
 * @author leo
 * @date 2014-3-13
 */
package p01x.p012_Word_Break;


import java.util.HashSet;
import java.util.Set;

/**
 * <pre>
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 *
 * Return true because "leetcode" can be segmented as "leet code".
 * </pre>
 *
 * @author leo
 */
public class Solution {
    boolean preMatch(char[] array, int begin, String p) {
        if (array.length - begin < p.length()) {
            return false;
        }
        for (int i = 0; i < p.length(); i++) {
            if (array[i + begin] != p.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean match(char[] array, int begin, Set<String> dict) {
        if (begin == array.length) {
            return true;
        }
        for (String p : dict) {
            if (preMatch(array, begin, p)) {
                if (match(array, begin + p.length(), dict)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Status: Time Limit Exceeded
     * Submitted: 0 minutes ago
     * Last executed input:	"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
     * aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
     * ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
     *
     * @param s
     * @param dict
     * @return
     */
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0 || dict.contains(s)) {
            return true;
        }
        char[] arr = s.toCharArray();
        return match(arr, 0, dict);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().wordBreak("leetcode", new HashSet<String>() {{
            add("leet");
            add("code");
        }}));
    }
}
