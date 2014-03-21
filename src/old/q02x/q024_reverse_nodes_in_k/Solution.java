/**
 * Solution.java
 * @author leo
 * @date 2013-3-31
 */
package old.q02x.q024_reverse_nodes_in_k;

/**
 * <pre>
 * Reverse Nodes in k-Group 325 / 1028
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * 
 * Only constant memory is allowed.
 * For example,
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        System.out.println("input:\t" + head);
        System.out.println("result:\t" + s.reverseKGroup(head, 2));
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
    
    private static class List {
        ListNode head;
        ListNode tail;
        public List(ListNode head, ListNode tail) {
            this.head = head;
            this.tail = tail;
        }
    }

    private List reverse(ListNode head) {
        if (head == null || head.next == null) {
            return new List(head, head);
        }
        ListNode pre = null, cur = head, next = head.next;
        ListNode tail = head;
        while (next != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = cur.next;
        }
        cur.next = pre;
        return new List(cur, tail);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 2) {
            return head;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode p0 = pre, p1 = head, p2 = head, next = head;
        while (true) {
            int i = 0;
            while (i < k - 1 && p2 != null) {
                p2 = p2.next;
                i ++;
            }
            if (i < k - 1 || p2 == null) {
                p0.next = next;
                break;
            }
            next = p2.next;
            p2.next = null;
            List l = reverse(p1);
            p0.next = l.head;
            p0 = l.tail;
            p1 = p2 = next;
        }
        return pre.next;
    }
}
