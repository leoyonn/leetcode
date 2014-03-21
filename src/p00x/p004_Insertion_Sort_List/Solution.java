/**
 * Solution.java
 * @author leo
 * @date 2014-3-13
 */
package p00x.p004_Insertion_Sort_List;


/**
 * <pre>
 * Sort a linked list using insertion sort.
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
     * 21 / 21 test cases passed.
     * Status: Accepted
     * Runtime: 532 ms
     *
     * @param head
     * @return
     */
    public ListNode insertSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode doneHead = new ListNode(Integer.MIN_VALUE);
        while (head != null) {
            ListNode cur = doneHead;
            while (cur.next != null && cur.next.val <= head.val) {
                cur = cur.next;
            }
            ListNode tail = cur.next;
            cur.next = head;
            head = head.next;
            cur.next.next = tail;
        }
        return doneHead.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = new ListNode(3);
        head.next(new ListNode(4)).next(new ListNode(1)).next(new ListNode(5)).next(new ListNode(2));
        System.out.println(s.insertSortList(head));
    }
}
 