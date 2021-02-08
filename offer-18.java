/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        }
        ListNode pre = head.next;
        ListNode current = head;
        while (pre != null) {
            if (pre.val == val) {
                current.next = pre.next;
                break;
            }else {
                pre = pre.next;
                current = current.next;
            }
        }
        return head;
    }
}
