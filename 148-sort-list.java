/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 题目：无序链表整理为有序的链表
 * 思路：插入排序
 */
class Solution {
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        ListNode slowHead = slow.next;
        slow.next = null;
        return merge(sortList(head), sortList(slowHead));
    }

    private ListNode merge(ListNode first, ListNode second) {
        ListNode head = new ListNode(0);
        ListNode result = head;
        while(first != null && second != null) {
            if (first.val < second.val) {
                head.next = first;
                first = first.next;
            }else {
                head.next = second;
                second = second.next;
            }
            head = head.next;
        }
        if (first != null) {
            head.next = first;
        }
        if (second != null) {
            head.next = second;
        }
        return result.next;
    }
}
