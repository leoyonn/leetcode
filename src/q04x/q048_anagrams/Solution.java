/**
 * Solution.java
 * @author leo
 * @date 2013-4-3
 */
package q04x.q048_anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * Anagrams
 * Given an array of strings, return all groups of strings that are anagrams.
 * Note: All inputs will be in lower-case.
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    public static void  main(String [] args) {
        Solution s = new Solution();
        System.out.println(s.anagrams(new String[]{""}));
    }

    private Map<String, List<String>> anamap = new HashMap<String, List<String>>();
    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> res = new ArrayList<String>();
        if (strs == null || strs.length == 0) {
            return res;
        }
        // use a <ana, str> map
        anamap.clear();
        for (String s: strs) {
            if (s.length() < 2) {
                put(s, s);
            } else {
                char[] ana = s.toCharArray();
                Arrays.sort(ana);
                put(String.valueOf(ana), s);
            }
        }
        for (Map.Entry<String, List<String>> e :anamap.entrySet()) {
            List<String> l = e.getValue();
            if (l.size() > 1) {
                res.addAll(l);
            }
        }
        return res;
    }
    
    private void put(String k, String v) {
        List<String> l = anamap.get(k);
        if (l == null) {
            l = new ArrayList<String>();
            anamap.put(k, l);
        }
        l.add(v);
    }
}
