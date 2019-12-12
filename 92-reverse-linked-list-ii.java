/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 题目：从位置 m 开始翻转链表
 * 解决：提过队列的方式存储数组，然后交换对应位置的值
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        List<ListNode> nodes = new ArrayList<ListNode>();
        while (head != null) {
            nodes.add(head);
            head = head.next;
        }
        while (m < n) {
            ListNode left = nodes.get(m - 1);
            ListNode right = nodes.get(n - 1);
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
            m++;
            n--;
        }
        return nodes.get(0);
    }
}
