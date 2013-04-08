/**
 * Solution.java
 * @author leo
 * @date 2013-3-21
 */
package q00x.q001_two_sum;
import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * Two Sum 511 / 5099
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, 
 * where index1 must be less than index2. 
 * Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	int[] r = s.twoSum_v2(new int[]{1, 2, 3}, 3);
    	System.out.println(r[0] + ", " + r[1]);
    }

	/**
	 * Two Sum
	 * @param numbers
	 * @param target
	 * @return
	 */
    public int[] twoSum_v1(int[] numbers, int target) {
        // assume input are valid...
    	for (int i = 0; i < numbers.length - 1; i ++) {
    		for (int j = i + 1; j < numbers.length; j ++) {
    			if (numbers[i] + numbers[j] == target) {
    				return new int[] {i + 1, j + 1};
    			}
    		}
    	}
    	return new int[]{-1, -1};
    }

	/**
	 * Two Sum
	 * @param numbers
	 * @param target
	 * @return
	 */
    public int[] twoSum_v2(int[] numbers, int target) {
    	Map<Integer, Integer> idxMap = new HashMap<Integer, Integer>();
    	for (int i = 0; i < numbers.length; i ++) {
    		Integer comp = idxMap.get(target - numbers[i]);
    		if (comp != null) {
    			return new int[]{comp + 1, i + 1};
    		}
    		idxMap.put(numbers[i], i);
    	}
    	return new int[]{-1, -1};
    }

}
