/**
 * Solution.java
 * @author leo
 * @date 2014-3-13
 */
package p01x.p013_Copy_List_with_Random_Pointer;


/**
 * <pre>
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 *
 * Return a deep copy of the list.
 * </pre>
 *
 * @author leo
 */
public class Solution {
    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

    /**
     * 11 / 11 test cases passed.
     * Status: Accepted
     * Runtime: 540 ms
     *
     * @param head
     * @return
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }
        RandomListNode p = head, newp;
        while (p != null) {
            RandomListNode next = p.next;
            newp = p.next = new RandomListNode(p.label);
            newp.next = next;
            p = next;
        }
        p = head;
        while (p != null) {
            p.next.random = p.random == null ? null : p.random.next;
            p = p.next.next;
        }
        p = head;
        head = head.next;
        while (p != null) {
            newp = p.next;
            p.next = newp.next;
            p = p.next;
            newp.next = p == null ? null : p.next;
        }
        return head;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().copyRandomList(null));
    }
}
