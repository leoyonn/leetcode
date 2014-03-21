/**
 * Solution.java
 * @author leo
 * @date 2013-3-31
 */
package old.q02x.q023_swap_nodes_inpair;


/**
 * <pre>
 * Swap Nodes in Pairs 529 / 1199
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. You may not modify the values in the list, 
 * only nodes itself can be changed.
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    /**
     * Definition for singly-linked list.
     * @author leo
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode p0 = pre, p1 =  head, p2 = p1.next, next = p2.next;
        while (true) {
            p0.next = p2;
            p1.next = next;
            p2.next = p1;
            if (next == null || next.next == null) {
                break;
            }
            p0 = p1;
            p1 = next;
            p2 = next.next;
            next = p2.next;
        }
        return pre.next;
    }
}
