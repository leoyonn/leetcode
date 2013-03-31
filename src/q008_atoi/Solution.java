package q008_atoi;

public class Solution {
	public static void main(String [] args) {
		Solution s = new Solution();
		System.out.println(s.atoi(""));
		System.out.println(s.atoi("1"));
		System.out.println(s.atoi("112122121"));
		System.out.println(s.atoi("-900"));
	}

	public int atoi(String a) {
    	if (a == null || a.length() == 0) {
    		return 0;
    	}
    	int i = 0;
    	long r = 0;
    	boolean neg = false;
    	char[] arr = a.trim().toCharArray();
    	if (arr[0] == '+') {
    		i ++;
    	} else if (arr[0] == '-') {
    		i ++;
    		neg = true;
    	}
    	while (i < arr.length) {
    		char c = arr[i ++];
    		if (c > '9' || c < '0' ) {
    			break;
    		}
    		r = r * 10 + (c - '0');
    	}
    	if (neg) {
    		r = -r;
    	}
    	return (int) (r < Integer.MIN_VALUE ? Integer.MIN_VALUE :
    			(r > Integer.MAX_VALUE ? Integer.MAX_VALUE : r));
    }
}