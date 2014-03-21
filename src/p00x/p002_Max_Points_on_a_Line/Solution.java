/**
 * Solution.java
 * @author leo
 * @date 2014-3-13
 */
package p00x.p002_Max_Points_on_a_Line;


import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * </pre>
 *
 * @author leo
 */
public class Solution {
    public static class Point {
        int x;
        int y;

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    boolean equals(Point p1, Point p2) {
        return p1.x == p2.x && p1.y == p2.y;
    }

    double k(Point p1, Point p2) {
        return p1.x == p2.x ? Double.NaN : p1.y == p2.y ? 0 : (p1.y - p2.y) / (double) (p1.x - p2.x);
    }

    /**
     * 27 / 27 test cases passed.
     * Status: Accepted
     * Runtime: 432 ms
     *
     * @param points
     * @return
     */
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        } else if (points.length == 1) {
            return 1;
        } else if (points.length == 2) {
            return 2;
        }
        int maxk = 1;
        for (int i = 0; i < points.length - 1; i++) {
            int dup = 0;
            Map<Double, Integer> kcount = new HashMap<Double, Integer>();
            for (int j = i + 1; j < points.length; j++) {
                if (equals(points[i], points[j])) {
                    dup++;
                    continue;
                }
                double k = k(points[i], points[j]);
                Integer v = kcount.get(k);
                kcount.put(k, v == null ? 1 : v + 1);
            }
            if (maxk < dup + 1) {
                maxk = dup + 1;
            }
            for (int c : kcount.values()) {
                int k = dup + c + 1;
                if (k > maxk) {
                    maxk = k;
                }
            }
        }
        return maxk;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Point[] points = new Point[]{new Point(1, 1), new Point(1, 1), new Point(1, 1)};
        System.out.println(s.maxPoints(points));
    }
}
