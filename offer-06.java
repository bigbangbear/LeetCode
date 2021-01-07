/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] reversePrint(ListNode head) {

        List<ListNode> nodes = new ArrayList<ListNode>();
        while (head != null) {
            nodes.add(head);
            head = head.next;
        }
        int[] result = new int[nodes.size()];
        for (int i = 0; i < nodes.size(); i++) {
            result[i] = nodes.get(nodes.size() - 1 - i).val;
        }
        return result;

    }
}
