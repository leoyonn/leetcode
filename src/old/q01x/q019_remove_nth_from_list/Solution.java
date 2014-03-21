/**
 * Solution.java
 * @author leo
 * @date 2013-3-21
 */
package old.q01x.q019_remove_nth_from_list;


/**
 * <pre>
 * Remove Nth Node From End of List 540 / 1449
 * Given a linked list, remove the nth node from the end of list and return its head.
 * For example,
 *    Given linked list: 1->2->3->4->5, and n = 2.
 *    After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 * </pre>
 * 
 * @author Leo
 */
public class Solution {
    /**
     * Definition for singly-linked list.
     * 
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode p1 = pre, p2 = pre;
        while (p1 != null && n >= 0) {
            p1 = p1.next;
            n --;
        }
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;
        return pre.next;
    }
}
