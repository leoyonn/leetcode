/**
 * Solution.java
 * @author leo
 * @date 2014-3-13
 */
package p00x.p003_Sort_List;


/**
 * <pre>
 * Sort a linked list in O(n log n) time using constant space complexity.
 * </pre>
 *
 * @author leo
 */
public class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        public ListNode next(ListNode next) {
            this.next = next;
            return next;
        }

        @Override
        public String toString() {
            return next == null ? val + "." : val + "->" + next;
        }
    }

    /**
     * TLE
     *
     * @param head
     * @return
     */
    public ListNode sortList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode l = null, lc = null, r = null, rc = null, m = head;
        head = head.next;
        while (head != null) {
            if (head.val < m.val) {
                if (lc == null) {
                    lc = l = head;
                } else {
                    lc.next = head;
                    lc = lc.next;
                }
            } else {
                if (rc == null) {
                    rc = r = head;
                } else {
                    rc.next = head;
                    rc = rc.next;
                }
            }
            head = head.next;
        }
        if (lc != null) {
            lc.next = null;
        }
        if (rc != null) {
            rc.next = null;
        }
        l = sortList1(l);
        r = sortList1(r);
        if (l == null) {
            l = m;
        } else {
            lc.next = m;
        }
        m.next = r;
        return l;
    }

    /**
     * 15 / 15 test cases passed.
     * Status: Accepted
     * Runtime: 524 ms
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode left = head, right = slow.next;
        slow.next = null;
        left = sortList(left);
        right = sortList(right);
        ListNode cur = head = new ListNode(-1);
        while (left != null && right != null) {
            if (left.val <= right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        while (left != null) {
            cur.next = left;
            cur = left;
            left = left.next;
        }
        while (right != null) {
            cur.next = right;
            cur = right;
            right = right.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = new ListNode(3);
        head.next(new ListNode(4)).next(new ListNode(1)).next(new ListNode(5)).next(new ListNode(2));
        System.out.println(s.sortList(head));
    }
}
 