/**
 * Solution.java
 * @author leo
 * @date 2014-3-13
 */
package p00x.p_009_Linked_List_Cycle_II;


/**
 * <pre>
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * Follow up:
 * Can you solve it without using extra space?
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

    /**
     * 16 / 16 test cases passed.
     * Status: Accepted
     * Runtime: 372 ms
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head.next, slow = head, spot = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                spot = slow;
                break;
            }
        }
        if (spot == null) {
            return null;
        }
        fast = head;
        while (fast != spot) {
            fast = fast.next;
            spot = spot.next;
        }
        return fast;
    }

    public static void main(String[] args) {
    }
}
 