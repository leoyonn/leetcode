/**
 * Solution.java
 * @author leo
 * @date 2013-4-3
 */
package old.q05x.q056_insert_interval;

import java.util.ArrayList;

/**
 * <pre>
 * Insert Interval
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 * 
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * 
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
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

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> res = new ArrayList<Interval>();
        int i;
        for (i = 0; i <intervals.size(); i ++) {
            Interval in = intervals.get(i);
            if (in.start > newInterval.end) {
                res.add(newInterval);
                res.addAll(intervals.subList(i, intervals.size()));
                return res;
            } else if (in.end < newInterval.start) {
                res.add(in);
            } else {
                newInterval.start = Math.min(in.start, newInterval.start);
                newInterval.end = Math.max(in.end, newInterval.end);
            }
        }
        res.add(newInterval);
        return res;
    }
}
