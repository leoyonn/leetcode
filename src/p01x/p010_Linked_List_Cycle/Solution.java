/**
 * Solution.java
 * @author leo
 * @date 2014-3-13
 */
package p01x.p010_Linked_List_Cycle;


/**
 * <pre>
 * Given a linked list, determine if it has a cycle in it.
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
     * Runtime: 400 ms
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
    }
}
 