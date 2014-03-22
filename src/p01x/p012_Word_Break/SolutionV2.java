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
public class SolutionV2 {
    class Node {
        char c;
        Node[] next;
        boolean word;

        Node(char c) {
            this.c = c;
            this.next = new Node[26];
            this.word = false;
        }

        void insert(String s) {
            Node cur = this;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (cur.next[c - 'a'] == null) {
                    cur.next[c - 'a'] = new Node(c);
                }
                cur = cur.next[c - 'a'];
            }
            cur.word = true;
        }

        public boolean match(String s, int i, int j) {
            Node cur = this;
            while (i <= j) {
                Node next = cur.next[s.charAt(i) - 'a'];
                if (next == null) {
                    return false;
                }
                i++;
                cur = next;
            }
            return cur.word;
        }
    }

    /**
     * 21 / 21 test cases passed.
     * Status: Accepted
     * Runtime: 296 ms
     *
     * @param s
     * @param dict
     * @return
     */
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0 || dict.contains(s)) {
            return true;
        }
        Node root = new Node('*');
        for (String w : dict) {
            root.insert(w);
        }
        boolean[] ok = new boolean[s.length() + 1];
        ok[0] = true;
        for (int j = 1; j <= s.length(); j++) {
            for (int i = j; i > 0; i--) {
                if (ok[i - 1] && root.match(s, i - 1, j - 1)) {
                    ok[j] = true;
                    break;
                }
            }
        }
        return ok[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(new SolutionV2().wordBreak("a", new HashSet<String>() {{
        }}));
    }
}
