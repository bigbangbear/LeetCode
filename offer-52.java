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
           Set<ListNode> a = new HashSet<ListNode>();
        Set<ListNode> b = new HashSet<ListNode>();
        while(headA != null || headB != null) {

            if (headA != null) {
                if (b.contains(headA)) {
                    return headA;
                }
                a.add(headA);
                headA = headA.next;
            }

            if (headB != null) {
                if (a.contains(headB)) {
                    return headB;
                }
                b.add(headB);
                headB = headB.next;
            }

        }
        return null;


    }
}

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      ListNode a = headA;
        ListNode b = headB;
        boolean aEnd = false;
        boolean bEnd = false;
        while(a != null && b != null && a != b) {
            a = a.next;
            b = b.next;
            if (a == null) {
                if (aEnd) {
                    return null;
                }
                aEnd = true;
                a = headB;
            }
            if (b == null) {
                if (bEnd) {
                    return null;
                }
                bEnd = true;
                b = headA;
            }
        }
        if (a == b) {
            return a;
        }else {
            return null;
        }    }
}
