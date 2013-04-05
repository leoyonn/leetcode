/**
 * Solution.java
 * @author leo
 * @date 2013-3-31
 */
package q06x.q064_merge_2_sorted_list;



/**
 * <pre>
 * Merge Two Sorted Lists
 * Merge two sorted linked lists and return it as a new list.
 *  The new list should be made by splicing together the nodes of the first two lists.
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    /**
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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(0), p = head;
        while (l1 != null || l2 != null) {
            if (l2 == null || l1 != null && l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        p.next = null;
        return head.next;
    }
}