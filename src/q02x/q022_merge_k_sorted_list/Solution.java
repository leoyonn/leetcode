/**
 * Solution.java
 * @author leo
 * @date 2013-3-31
 */
package q02x.q022_merge_k_sorted_list;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;


/**
 * <pre>
 * Merge k Sorted Lists 495 / 1565
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * </pre>
 * 
 * @author leo
 */
public class Solution {
    /**
     * Definition for singly-linked list.
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
    
    private static Comparator<ListNode> COMP = new Comparator<ListNode>() {
        @Override
        public int compare(ListNode n1, ListNode n2) {
            return n1.val > n2.val ? 1 : n1.val < n2.val ? -1 : 0;
            //Integer.compare(n1.val, n2.val);
        }
    };

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        } else if (lists.size() == 1) {
            return lists.get(0);
        }
        
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.size(), COMP);
        for (ListNode head: lists) {
            if (head != null) {
                q.add(head);
            }
        }
        ListNode pre = new ListNode(0), p = pre;
        while (!q.isEmpty()) {
            p.next = q.poll();
            p = p.next;
            if (p.next != null) {
                q.add(p.next);
            }
        }
        p.next = null;
        return pre.next;
    }
}
