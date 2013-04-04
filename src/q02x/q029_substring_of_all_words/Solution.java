/**
 * Solution.java
 * @author leo
 * @date 2013-3-31
 */
package q029_substring_of_all_words;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * http://leetcode.com/onlinejudge#question_30
 * <pre>
 * Substring with Concatenation of All Words
 * You are given a string, S, and a list of words, L, that are all of the same length.
 * Find all starting indices of substring(s) in S that is a concatenation of each word
 * in L exactly once and without any intervening characters.
 * 
 * For example, given:
 * S: "barfoothefoobarman"
 * L: ["foo", "bar"]
 * 
 * You should return the indices: [0,9].
 * (order does not matter).
 * 
 * Solve this problem
 * </pre>
 * 
 * <b> 1s on Large Judge.</b>
 * 
 * @author leo
 */
public class Solution {
	public static void main(String [] args) {
		Solution s = new Solution();
        System.out.println(s.findSubstring("barfoothefoobarman", new String[]{"bar", "foo"}));
	}

	/**
	 * @see search for 'sunday' from google.
	 * generate sunday's next array of pattern 'p'. 
	 * @param p
	 * @return
	 */
    private int[] makeSunday(char[] p) {
        int[] next = new int[26];
        for (int i = 0; i < 26; i++) {
            next[i] = p.length + 1;
        }
        for (int i = 0; i < p.length; i++) {
            next[p[i] - 'a'] = p.length - i;
        }
        return next;
    }

    /**
     * find 1 match from string s of pattern p from start point of s.
     * @param s
     * @param p
     * @param start
     * @return
     */
    public int find1(char[] s, char[] p, int start) {
        int[] next = makeSunday(p);
        for (int i = start; i <= s.length - p.length;) {
            int l = p.length - 1;
            while (l >= 0 && s[i + l] == p[l]) {
                l--;
            }
            if (l < 0) {
                return i;
            }
            if (i >= s.length - p.length) {
                break;
            }
            i += next[s[i + p.length] - 'a'];
        }
        return -1;
    }

    /**
     * find all matches, and put into position map: <pos-in-s, pattern>
     * @param s
     * @param p
     * @param posMap
     */
    private void findAll(char[] s, String p, Map<Integer, String>posMap) {
        char[] parr = p.toCharArray();
        int pos = find1(s, parr, 0);
        while(pos >= 0) {
            posMap.put(pos, p);
            pos = find1(s, parr, pos + 1);
        }
    }

    /**
     * entry func.
     * @param S
     * @param L
     * @return
     */
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        // edge cases
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (S == null || L == null || L.length == 0 || S.length() < L[0].length()) {
            return res;
        }
        // count all words, and find there occurence
        char []s = S.toCharArray();
        Map<String, Integer> expect = new HashMap<String, Integer>();
        Map<String, Integer> infact = new HashMap<String, Integer>();
        Map<Integer, String> posMap = new HashMap<Integer, String>();
        for (int i = 0; i < L.length; i ++) {
            Integer c = expect.get(L[i]);
            expect.put(L[i], c == null ? 1 : c + 1);
        }
        for (Map.Entry<String, Integer> e: expect.entrySet()) {
            findAll(s, e.getKey(), posMap);
        }
        // check all possible Concatenation, which means infact == expect.
        int size = L[0].length();
        for (int i = 0; i <= s.length - size * L.length; i ++) {
            String w = posMap.get(i);
            if (w == null) { // no words starts at i
                continue;
            }
            infact.clear();
            infact.put(w, 1);
            int j = 0;
            int cnt = 1;
            for (j = i + size; j < s.length; j += size) {
                w = posMap.get(j);
                if (w == null) { // no words starts at j
                    break;
                }
                Integer c = infact.get(w);
                c = c == null ? 1 : c + 1;
                if (c > expect.get(w)) { // too much w
                    break;
                }
                infact.put(w, c);
                cnt ++;
            }
            // wow! found one start at i
            if (cnt == L.length) {
                res.add(i);
            }
        }
        return res;
    }
}
