/**
 * Solution.java
 * @author leo
 * @date 2014-3-13
 */
package p01x.p016_Candy;


/**
 * <pre>
 * There are N children standing in a line. Each child is assigned a rating value.
 *
 * You are giving candies to these children subjected to the following requirements:
 *
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 * </pre>
 *
 * @author leo
 */
public class Solution {
    int enough(int r1, int r2, int c1, int c2) {
        return r1 > r2 ? c2 > c1 + 1 ? c2 : c1 + 1 : c2 > 1 ? c2 : 1;
    }

    /**
     * 27 / 27 test cases passed.
     * Status: Accepted
     * Runtime: 424 ms
     *
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        } else if (ratings.length == 1) {
            return 1;
        }
        int[] candies = new int[ratings.length];
        candies[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            candies[i] = enough(ratings[i], ratings[i - 1], candies[i - 1], candies[i]);
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            candies[i] = enough(ratings[i], ratings[i + 1], candies[i + 1], candies[i]);
        }
        int all = 0;
        for (int candy : candies) {
            System.out.print(candy + ", ");
            all += candy;
        }
        return all;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().candy(new int[]{4, 2, 3, 4, 1}));
    }
}
 