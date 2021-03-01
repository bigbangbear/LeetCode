/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node copyHead = copyNode(head);
        Node headNext = head.next;
        Node copyNext = copyHead;
        map.put(head, copyHead);
        while(headNext != null) {
            Node next = copyNode(headNext);
            copyNext.next = next;
            copyNext = copyNext.next;
            map.put(headNext, copyNext);
            headNext = headNext.next;
        }
        headNext = head;
        copyNext = copyHead;
        while(headNext != null) {
            if (headNext.random != null) {
                copyNext.random = map.get(headNext.random);
            }
            headNext = headNext.next;
            copyNext = copyNext.next;
        }

        return copyHead; 
    }

    private Node copyNode(Node node) {
        Node copy = new Node(node.val);
        return copy;
    }
}
