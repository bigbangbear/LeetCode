/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) {
            return head;
        }
        int length = 0;
        ListNode pre = head;
        while (pre != null) {
            length++;
            pre = pre.next;
        }
        k = k % length;
        if (k == 0) {
            return head;
        }
        ListNode current = head;
        pre = head;
        for (int i=0; i<k; i++) {
            pre = pre.next;
        }
        while (pre.next != null) {
            pre = pre.next;
            current = current.next;
        }
        pre.next = head;
        head = current.next;
        current.next = null;
        return head;
    }
}
