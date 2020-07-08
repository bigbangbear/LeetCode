class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode first = head;
        ListNode last = head;
        while (first != null) {
            if (first.next == null) {
                break;
            }
            if (first.next.next == null) {
                last = last.next;
                break;
            }
            first = first.next.next;
            last = last.next;
        }

        return last;
   } 
}
