class Solution {


    private Node head = null;
    private Node pre = null;

    public Node treeToDoublyList(Node root) {
        help(root);
        if (head != null && pre != null) {
            head.left = pre;
            pre.right = head;
        }
        return head;
    }

    private void help(Node root) {
        if (root == null) {
            return;
        }
        treeToDoublyList(root.left);
        if (head == null) {
            head = root;
            pre = root;
        }else {
            pre.right = root;
            root.left = pre;
            pre = root;
        }
        treeToDoublyList(root.right);
    }
}
