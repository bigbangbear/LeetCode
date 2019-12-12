/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * [-1,5,3,4,0]
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        // 至少有两个元素
        ListNode sort = head;
        ListNode unsort = head.next;
        sort.next = null;

        // 遍历后面未排序的节点插入到前面已排序的节点之后
        while (unsort != null) {
            ListNode current = unsort;
            unsort = unsort.next;

            ListNode pre = null;
            ListNode next = sort;
            boolean isInsert = false;
            while (next != null) {
                if (current.val <= next.val) {
                    // 小于等于当前元素，插入当前元素之前
                    if (pre == null) {
                        current.next = next;
                        sort = current;
                    } else {
                        pre.next = current;
                        current.next = next;
                    }
                    isInsert = true;
                    break;
                } else {
                    // 大于当前元素，指针后移
                    pre = next;
                    next = next.next;
                }
            }
            // 比当前已排队列的元素都大，插入到末尾
            if (isInsert == false) {
                pre.next = current;
                current.next = null;
            }
        }
        return sort;
    }
}
