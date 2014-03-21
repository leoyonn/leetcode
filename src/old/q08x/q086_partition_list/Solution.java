/**
 * Solution.java
 * @author leo
 * @date 2013-4-6
 */
package old.q08x.q086_partition_list;


/**
 * <pre>
 * Partition List 276 / 946
 * Given a linked list and a value x, partition it such that all nodes less than
 * x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
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

    /**
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode lhead = new ListNode(x - 1), rhead = new ListNode(x + 1), pl = lhead, pr = rhead;
        pl.next = pr; pr.next = head;
        while (pr.next != null) {
            while (pr.next != null && pr.next.val >= x) {
                pr = pr.next;
            }
            pl.next = pr.next;
            while (pl.next != null && pl.next.val < x) {
                pl = pl.next;
            }
            pr.next = pl.next;
        }
        pl.next = rhead.next;
        return lhead.next;
    }
}
