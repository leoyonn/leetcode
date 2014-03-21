/**
 * Solution.java
 * @author leo
 * @date 2013-4-6
 */
package old.q08x.q083_remove_dup_frome_list_II;


/**
 * <pre>
 * Remove Duplicates from Sorted List II 338 / 1074
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * 
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
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

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(0), p0 = head, p1 = head.next;
        pre.next = p0;
        head = pre;
        while (p1 != null) {
            boolean dup = false;
            while (p1 != null && p1.val == p0.val) {
                dup = true;
                p1 = p1.next;
            }
            if (dup) {
                pre.next = p1;
                if (p1 == null) {
                    pre.next = null;
                    break;
                }
                p0 = p1;
                p1 = p1.next;
            } else {
                p0.next = p1;
                pre = p0;
                p0 = p1;
                if (p1 != null) {
                    p1 = p1.next;
                }
            }
        }
        return head.next;
    }
}
