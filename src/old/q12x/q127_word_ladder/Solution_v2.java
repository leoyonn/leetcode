/**
 * Solution.java
 * [CopyRight]
 * @author leo leoyonn@gmail.com
 * @date 2013-5-10 下午4:32:39
 */
package old.q12x.q127_word_ladder;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * <pre>
 * Word LadderFeb 112580 / 9279
 * Given two words (start and end), and a dictionary, 
 * find the length of shortest transformation sequence from start to end, such that:
 * 
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,
 * 
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * 
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * 
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * </pre>
 * 
 * @author leo
 */
public class Solution_v2 {
    public static void main(String[] args) {
        System.out.println(new Solution_v2().ladderLength("hot", "dog", new HashSet<String>() {
            private static final long serialVersionUID = 1L;
            {
                add("hot");
                add("dog");
                add("dot");
            }
        }));
    }

    /**
     * entry func
     * @param start
     * @param end
     * @param dict
     * @return
     */
    public int ladderLength(String start, String end, HashSet<String> dict) {
        if (start.equals(end) || !dict.contains(start) || !dict.contains(end) || dict.size() < 2) {
            return 0;
        }
        Set<String> done = new HashSet<String>();
        Queue<String> q = new LinkedList<String>();
        done.add(start);
        q.add(start);
        int n = 1, nchild = 0, step = 1;
        while (!q.isEmpty()) {
            String str = q.poll();
            char[] s = str.toCharArray();
            for (int i = 0; i < s.length; i ++) {
                if (i > 0) { // restore
                    s[i - 1] = str.charAt(i - 1);
                }
                for (char c = 'a'; c <= 'z'; c ++) {
                    if (str.charAt(i) == c) {
                        continue;
                    }
                    s[i] = c;
                    String child = String.valueOf(s);
                    if (child.equals(end)) {
                        return step + 1;
                    }
                    if (dict.contains(child) && !done.contains(child)) {
                        done.add(child);
                        q.add(child);
                        nchild ++;
                    }
                }
            }
            if (--n == 0) { // finished this level, go to child-level
                n = nchild;
                nchild = 0;
                step ++;
            }
        }
        return 0;
    }
}
