/**
 * Solution.java
 * @author leo
 * @date 2013-4-6
 */
package q09x.q092_reverse_list_II;

/**
 * <pre>
 * Reverse Linked List II 484 / 1487
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * 
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * 
 * return 1->4->3->2->5->NULL.
 * 
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ? m ? n ? length of list.
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n) {
            return head;
        }
        ListNode preHead = new ListNode(0), cur = preHead;
        preHead.next = head;
        int i = 0;
        while (++i < m) {
            cur = cur.next;
        }
        ListNode pre = cur, mth = null, nth = cur.next;
        cur = cur.next;
        while (i++ <= n) {
            ListNode next = cur.next;
            cur.next = mth;
            mth = cur;
            cur = next;
        }
        nth.next = cur;
        pre.next = mth;
        return preHead.next;
    }
}
