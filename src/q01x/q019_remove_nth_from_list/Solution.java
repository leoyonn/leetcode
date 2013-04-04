package q01x.q019_remove_nth_from_list;


/**
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
