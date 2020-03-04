/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * 思路：先输入到数组中，然后交换数组的位置
 */
class Solution {
    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<Integer>();
        while(head != null){
            list.add(head.val);
        }
        list.reverse();
        return Arrays.toArray(list);
    }
}
