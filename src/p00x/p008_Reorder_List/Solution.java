/**
 * Solution.java
 * @author leo
 * @date 2014-3-13
 */
package p00x.p008_Reorder_List;


/**
 * <pre>
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * You must do this in-place without altering the nodes' values.
 *
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * </pre>
 *
 * @author leo
 */
public class Solution {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode p1 = head, p2 = null;
        head = null;
        while (p1 != null) {
            p2 = p1.next;
            p1.next = head;
            head = p1;
            p1 = p2;
        }
        return head;
    }

    /**
     * 13 / 13 test cases passed.
     * Status: Accepted
     * Runtime: 480 ms
     *
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow.next;
        slow.next = null;
        fast = reverse(fast);
        slow = head;
        while (slow.next != null && fast != null) {
            ListNode p1 = slow.next, p2 = fast.next;
            slow.next = fast;
            fast.next = p1;
            slow = p1;
            fast = p2;
        }
        if (fast != null) {
            slow.next = fast;
        }
    }

    public static void main(String[] args) {
    }
}
 