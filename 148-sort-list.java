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
        if (head == null) {
            return null;
        }
        ListNode sort = head;
        ListNode unsort = head.next;
        sort.next = null;
        while (unsort != null) {
            ListNode current = unsort;
            unsort = unsort.next;

            boolean isInsert = false;
            ListNode pre = null;
            ListNode next = sort;
            while (next != null) {
                if (current.val <= next.val) {
                    if (pre == null) {
                        current.next = sort;
                        sort = current;
                    } else {
                        pre.next = current;
                        current.next = next;
                    }
                    isInsert = true;
                    break;
                } else {
                    pre = next;
                    next = next.next;
                }
            }
            if (!isInsert) {
                pre.next = current;
                current.next = null;
            }
        }
        return sort;
    }
}
