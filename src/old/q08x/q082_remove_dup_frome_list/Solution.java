/**
 * Solution.java
 * @author leo
 * @date 2013-4-6
 */
package old.q08x.q082_remove_dup_frome_list;


/**
 * <pre>
 * Remove Duplicates from Sorted List 384 / 769
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * 
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
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
        ListNode p0 = head, p1 = head.next;
        while (p1 != null) {
            while (p1 != null && p1.val == p0.val) {
                p1 = p1.next;
            }
            p0.next = p1;
            p0 = p1;
            if (p1 != null) {
                p1 = p1.next;
            }
        }
        return head;
    }
}
