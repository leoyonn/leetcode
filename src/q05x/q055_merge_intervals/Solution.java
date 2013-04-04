/**
 * Solution.java
 * @author leo
 * @date 2013-4-3
 */
package q05x.q055_merge_intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * <pre>
 * Merge IntervalsMar 27 '12
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    /**
     * Definition for an interval.
     */
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    private static Comparator<Interval> COMP_BY_START = new Comparator<Interval>(){
        @Override
        public int compare(Interval i1, Interval i2) {
            int c = Integer.compare(i1.start, i2.start);
            return c != 0 ? c : Integer.compare(i1.end, i2.end);
        }
    };

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if (intervals.size() < 2) {
            return intervals;
        }
        ArrayList<Interval> res = new ArrayList<Interval>();
        Collections.sort(intervals, COMP_BY_START);
        int i, j;
        for (i = 0; i < intervals.size(); i = j) { // O(n)
            Interval ini = intervals.get(i), inj;
            int end = ini.end;
            for (j = i + 1; j < intervals.size()
                    && (inj = intervals.get(j)).start <= end; j ++) {
                if (inj.end > end) {
                    end = inj.end;
                }
            }
            ini.end = end;
            res.add(ini);
        }
        return res;
    }
}
