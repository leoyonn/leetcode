/**
 * Solution.java
 * @author leo
 * @date 2014-3-13
 */
package p01x.p017_Gas_Station;


/**
 * <pre>
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 *
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 *
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 *
 * Note:
 * The solution is guaranteed to be unique.
 * </pre>
 *
 * @author leo
 */
public class Solution {
    /**
     * 13 / 13 test cases passed.
     * Status: Accepted
     * Runtime: 380 ms
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            gas[i] -= cost[i];
        }
        int sum = 0, begin = 0;
        for (int i = 0; i < gas.length * 2; i++) {
            if (i == begin + gas.length) {
                return begin;
            }
            int idx = i >= gas.length ? i - gas.length : i;
            sum += gas[idx];
            if (sum < 0) {
                if (i >= gas.length) {
                    return -1;
                }
                begin = i + 1;
                sum = 0;
            }
        }
        for (int i = 0; i < gas.length; i++) {
            gas[i] += cost[i];
        }
        return begin;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canCompleteCircuit(new int[]{4, 2, 3, 4, 1}, new int[]{5, 1, 2, 2, 4}));
    }
}
 