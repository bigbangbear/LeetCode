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
        ListNode pre = null;
        if (last.next != null && last.next.next != null) {
            pre = last.next.next;
        }else{
            return false;
        }
        while (last != pre) {
            if (pre == null || pre.next == null || pre.next.next == null) {
                return false;
            }
            pre = pre.next.next;
            last = last.next;
        }

        if (last == null || pre == null) {
            return false;
        }else{
            return true;
        }



    }
}
