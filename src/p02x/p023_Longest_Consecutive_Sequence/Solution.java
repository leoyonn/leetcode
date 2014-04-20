/**
 * Solution.java
 * @author leo
 * @date 2014-3-13
 */
package p02x.p023_Longest_Consecutive_Sequence;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <pre>
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 *
 * Your algorithm should run in O(n) complexity.
 * </pre>
 *
 * @author leo
 */
public class Solution {
    class Ele {
        int set;
        int size = 0;

        public Ele(int set, int size) {
            this.set = set;
            this.size = size;
        }

        public String toString() {
            return set + "|" + size;
        }
    }

    private Ele set(int v, Map<Integer, Ele> map) {
        Ele set = map.get(v), t;
        if (set == null) {
            return null;
        }
        int x = v;
        while ((set = map.get(x)).set != x) {
            x = set.set;
        }
        while ((t = map.get(v)).set != set.set) {
            map.put(v, set);
            v = t.set;
        }
        return set;
    }

    /**
     * <pre>
     * 67 / 67 test cases passed.
     * Status: Accepted
     * Runtime: 408 ms
     * Submitted: 0 minutes ago
     * </pre>
     *
     * @param num
     * @return
     */
    public int longestConsecutive_v1(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        } else if (num.length == 1) {
            return 1;
        }
        Map<Integer, Ele> map = new HashMap<Integer, Ele>();
        for (int v : num) {
            map.put(v, new Ele(v, 1));
        }
        for (Map.Entry<Integer, Ele> e : map.entrySet()) {
            int v = e.getKey();
            Ele curr = set(v, map),
                    prev = set(v - 1, map),
                    next = set(v + 1, map);
            boolean mergePrev = prev != null && curr != prev, mergeNext = next != null && curr != next;
            if (mergePrev) {
                prev.size += curr.size;
                map.put(v, prev);
                curr = prev;
            }
            if (mergeNext) {
                curr.size += next.size;
                map.put(v + 1, curr);
            }
        }
        int max = 0;
        for (Map.Entry<Integer, Ele> e : map.entrySet()) {
            if (e.getValue().size > max) {
                max = e.getValue().size;
            }
        }
        return max;
    }

    /**
     * <pre>
     * 67 / 67 test cases passed.
     * Status: Accepted
     * Runtime: 524 ms
     * </pre>
     *
     * @param num
     * @return
     */
    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        } else if (num.length == 1) {
            return 1;
        }
        Set<Integer> set = new HashSet<Integer>();
        for (int v : num) {
            set.add(v);
        }
        int max = 1;
        for (int v : num) {
            if (!set.contains(v)) {
                continue;
            }
            int x = v, n = 1;
            while (set.contains(--x)) {
                set.remove(x);
                n++;
            }
            x = v;
            while (set.contains(++x)) {
                set.remove(x);
                n++;
            }
            if (max < n) {
                max = n;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestConsecutive(new int[]{4, 0, -4, -2, 2, 5, 2, 0, -8, -8, -8, -8, -1, 7, 4, 5, 5, -4, 6, 6, -3}));
    }
}
 