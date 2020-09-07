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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> small = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode a, ListNode b) {
                if (a.val > b.val) {
                    return 1;
                }else if (a.val == b.val) {
                    return 0;
                }else {
                    return -1;
                }
            }
        });

        for (int i = 0; i < lists.length; i++) {
            if(lists[i] != null) {
    small.add(lists[i]);
            }
        
        }

        if (small.size() == 0) {
            return null;
        }

        ListNode result = small.peek();
        ListNode pre = small.peek();
        while (small.size() > 0) {
            ListNode top = small.poll();
            if (pre != top) {
                pre.next = top;
                pre = top;
            }
            if (top.next != null) {
                small.add(top.next);
            }
        }
        return result;
    }
}
