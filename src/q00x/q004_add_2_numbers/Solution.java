/**
 * Solution.java
 * @author leo
 * @date 2013-3-21
 */
package q00x.q004_add_2_numbers;

/**
 * <pre>
 * Add Two NumbersNov 1 '11787 / 2875
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * </pre>
 * 
 * @author leo
 */
public class Solution {
	/**
	 * Definition for singly-linked list.
	 */
	 public class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) {
			 val = x;
			 next = null;
		 }
	 }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	if (l1 == null) {
    		return l2;
    	} else if (l2 == null) {
    		return l1;
    	}
    	int carry = 0;
    	ListNode preHead = new ListNode(-1), p = preHead;
    	while (l1 != null || l2 != null) {
    		int v1 = 0, v2 = 0;
    		if (l1 != null) {
    			v1 = l1.val;
    			l1 = l1.next;
    		}
    		if (l2 != null) {
    			v2 = l2.val;
    			l2 = l2.next;
    		}
    		int sum = v1 + v2 + carry;
    		if (sum >= 10) {
	    		carry = 1;
	    		sum -= 10;
    		} else {
    			carry = 0;
    		}
    		p.next = new ListNode(sum);
    		p = p.next;
    	}
    	if (carry != 0) {
    		p.next = new ListNode(carry);
    	}
    	return preHead.next;
    }
}