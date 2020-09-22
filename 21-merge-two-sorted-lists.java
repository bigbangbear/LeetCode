/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = null;
        ListNode tail = null;
        while(l1 != null && l2 != null) {
            ListNode min = null;
            if (l1.val <= l2.val) {
                min = l1;
                l1 = l1.next;
            }else {
                min = l2;
                l2 = l2.next;
            }
            if (head == null) {
                head = min;
                tail = min;
            }else{
                tail.next = min;
                tail = tail.next;
            }
        }
        addLeft(tail, l1);
        addLeft(tail, l2);
        return head;
    }

    private void addLeft(ListNode tail, ListNode list) {
        while (list != null) {
            tail.next = list;
            tail = list;
            list = list.next;
        }
    }
}
