/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode last = head;
        ListNode pre = head.next;
        while (last != pre) {
            if (pre == null || pre.next == null ) {
                return false;
            }
            pre = pre.next.next;
            last = last.next;
        }

        return true;
    }
}
