/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
            public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
              ListNode scanA = headA;
            while (scanA != null) {
                ListNode scanB = headB;
                while (scanB != null) {
                    if (scanA == scanB) {
                        return scanA;
                    }
                    scanB = scanB.next;
                }
                scanA = scanA.next;
            }
            return null;
        }
      
}
