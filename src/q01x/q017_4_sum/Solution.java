package q01x.q017_4_sum;

import java.util.ArrayList;
import java.util.Arrays;


public class Solution {
	public static void main(String [] args) {
		Solution s = new Solution();
		System.out.println(s.fourSum(new int[]{1, -2, 1, 4}, 4));
	}

	private void add(ArrayList<ArrayList<Integer>> res, int vi, int vo, int vj, int vk) {
		ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(vi);
		l.add(vo);
		l.add(vj);
		l.add(vk);
		res.add(l);
	}

    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	if (num == null || num.length < 4) {
    		return res;
    	}
    	Arrays.sort(num);
    	for (int i = 0; i < num.length - 3; i ++) {
    		if (i > 0 && num[i] == num[i - 1]) {
    			continue;
    		}
    		for (int o = i + 1; o < num.length - 2; o ++) {
        		if (o > i + 1 && num[o] == num[o - 1]) {
        			continue;
        		}
	    		int expect = target - num[i] - num[o];
	    		for (int j = o + 1, k = num.length - 1; j < k;) {
	    			int infact = num[j] + num[k]; 
	    			if (infact == expect) {
	    				add(res, num[i], num[o], num[j], num[k]);
	    				while(j < k && num[j] == num[j + 1]) {
	    					j ++;
	    				}
	    				while(j < k && num[k] == num[k - 1]) {
	    					k --;
	    				}
	    				j ++;
	    				k --;
	    			} else if (infact < expect) {
	    				j ++;
	    			} else {
	    				k --;
	    			}
	    		}
    		}
    	}
		return res;
    }

}
