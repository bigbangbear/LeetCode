/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
      
        if (root == null) {
            return root;
        }

        List<Node> children = new ArrayList<Node>();
        children.add(root);

        while (children.size() > 0)  {
            List<Node> tmp = new ArrayList<Node>();

            for (int i = 0; i < children.size(); i++) {
                Node child = children.get(i);
                if (i < children.size() - 1) {
                    child.next = children.get(i + 1);
                }
                if (child.left != null) {
                    tmp.add(child.left);
                }
                if (child.right != null) {
                    tmp.add(child.right);
                }
            }
            children = tmp;
        }

        return root;
    }
}
