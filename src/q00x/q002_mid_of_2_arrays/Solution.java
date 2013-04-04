package q00x.q002_mid_of_2_arrays;


public class Solution {
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	int[] A = new int[]{1};
    	int[] B = new int[]{2,3,4};
    	System.out.println(s.findMedianSortedArrays(A, B));
    }
    
    boolean odd(int k) {
    	return (k & 1) == 1;
    }

    private double kth(int[] A, int ia, int sa, int[] B, int ib, int sb, int k) {
    	if (sa > sb) {
    		return kth(B, ib, sb, A, ia, sa, k);
    	} else if (sa == 0) {
    		return B[k - 1];
    	} else if (k == 1) {
    		return Math.min(A[ia], B[ib]);
    	}
    	int pa = Math.min(sa, k / 2);
    	int pb = k - pa;
    	if (A[ia + pa - 1] < B[ib + pb - 1]) {
    		return kth(A, ia + pa, sa - pa, B, ib, sb, k - pa);
    	} else {
    		return kth(A, ia, sa, B, ib + pb, sb - pb, k - pb);
    	}
    }

    /**
	 * 	Median of Two Sorted Arrays
	 * @param A
	 * @param B
	 * @return
	 */
    public double findMedianSortedArrays(int A[], int B[]) {
    	int m = A.length, n = B.length;
    	if (m == 0) {
    		return odd(n) ? B[n / 2] : (B[n / 2] + B[n / 2 - 1]) / 2.0;
    	} else if (n == 0) {
    		return odd(m) ? A[m / 2] : (A[m / 2] + A[m / 2 - 1]) / 2.0;
    	}
    	if (odd(m + n)) {
    		return kth(A, 0, m, B, 0, n, (m + n) / 2 + 1);
    	} else {
    		double	l = kth(A, 0, m, B, 0, n, (m + n) / 2),
    				r = kth(A, 0, m, B, 0, n, (m + n) / 2 + 1);
    		return (l + r) / 2;
    	}
    }
}
