/**
 * Solution.java
 * @author leo
 * @date 2014-3-13
 */
package p01x.p011_Word_Break_II;


import java.util.*;

/**
 * <pre>
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 *
 * Return all such possible sentences.
 *
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 *
 * A solution is ["cats and dog", "cat sand dog"].
 * </pre>
 *
 * @author leo
 */
public class Solution {
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
     * 24 / 24 test cases passed.
     * Status: Accepted
     * Runtime: 440 ms
     *
     * @param s
     * @param dict
     * @return
     */
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> result = new ArrayList<String>();
        if (s == null || s.length() == 0) {
            return result;
        }
        Node root = new Node('*');
        for (String w : dict) {
            root.insert(w);
        }
        boolean[] ok = new boolean[s.length() + 1];
        List<Integer>[] pres = (List<Integer>[]) new List<?>[s.length() + 1];
        ok[0] = true;
        for (int j = 1; j <= s.length(); j++) {
            for (int i = j; i > 0; i--) {
                if (ok[i - 1] && root.match(s, i - 1, j - 1)) {
                    ok[j] = true;
                    if (pres[j] == null) {
                        pres[j] = new ArrayList<Integer>();
                    }
                    pres[j].add(i - 1);
                }
            }
        }
        if (!ok[s.length()]) {
            return result;
        }
        trace(s.length(), s, pres, result, new Stack<Integer>());
        return result;
    }

    private void trace(int idx, String s, List<Integer>[] pres, List<String> result, Stack<Integer> stack) {
        if (idx == 0 || pres[idx] == null) {
            StringBuilder sb = new StringBuilder();
            if (idx != 0) {
                sb.append(s.substring(0, idx)).append(" ");
            }
            int begin = idx;
            for (int i = stack.size() - 1; i >= 0; i--) {
                sb.append(s.substring(begin, stack.get(i))).append(" ");
                begin = stack.get(i);
            }
            sb.setLength(sb.length() - 1);
            result.add(sb.toString());
            return;
        }
        stack.push(idx);
        for (int pre : pres[idx]) {
            trace(pre, s, pres, result, stack);
        }
        stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().wordBreak("aaa", new HashSet<String>() {{
            add("aa");
            add("a");
            add("and");
            add("sand");
            add("dog");
        }}));
    }
}
