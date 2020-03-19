/**
 * 利用数组处理，使用到额外的空间
 * 利用 Map 可以优化性能
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            if (list.contains(head)) {
                return head;
            }else {
                list.add(head);
                head = head.next;
            }
        }
        return null;
    }
}
