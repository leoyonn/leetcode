/**
 * Solution.java
 * @author leo
 * @date 2013-3-31
 */
package q06x.q060_rotate_list;

/**
 * <pre>
 * Rotate ListMar 28 '12274 / 932
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * 
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        System.out.println("input:\t" + head);
        System.out.println("result:\t" + s.rotateRight(head, 4));
    }

    /**
     * Definition for singly-linked list.
     * @author leo
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
        ListNode(int x, ListNode next) {
            val = x;
            this.next = next;
        }
        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode p = this;
            while (p != null) {
                sb.append(p.val).append("->");
                p = p.next;
            }
            sb.append("$");
            return sb.toString();
        }
    }
    
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || head.next == null || n == 0) {
            return head;
        }
        ListNode p1 = head, p2 = head;
        int len = 1;
        while (p1.next != null) {
            p1 = p1.next;
            len ++;
        }
        if (n >= len && ((n %= len) == 0)) {
            return head;
        }
        n = len - n;
        while (--n > 0) {
            p2 = p2.next;
        }
        ListNode newHead = p2.next;
        p2.next = null;
        p1.next = head;
        return newHead;
    }
}
