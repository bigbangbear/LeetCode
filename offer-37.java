/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    TreeNode empty = new TreeNode(0);
    final String none = "null";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
                StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (root != null) {
            List<TreeNode> list = new ArrayList<>();
            list.add(root);
            boolean hasChild = true;
            while (!list.isEmpty() && hasChild) {
                List<TreeNode> child = new ArrayList<>();
                hasChild = false;
                for (TreeNode node : list) {
                    if (node == empty) {
                        append(sb, empty);
                    } else {
                        append(sb, node);
                        if (node.left == null) {
                            child.add(empty);
                        } else {
                            hasChild = true;
                            child.add(node.left);
                        }
                        if (node.right == null) {
                            child.add(empty);
                        } else {
                            hasChild = true;
                            child.add(node.right);
                        }
                    }
                }
                list = child;
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("]");
        return sb.toString();
    }

    private void append(StringBuilder sb, TreeNode node) {
        if (node == empty) {
            sb.append("null,");
        } else {
            sb.append(node.val).append(",");
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty() || data.length() == 2) {
            return null;
        }
        data = data.substring(1, data.length() - 1);
        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        int index = 1;
        while (index < nodes.length) {
            List<TreeNode> child = new ArrayList<>();
            for (TreeNode node : list) {
                if (nodes[index].equals(none)) {
                    node.left = null;
                } else {
                    node.left = new TreeNode(Integer.parseInt(nodes[index]));
                    child.add(node.left);
                }
                index++;
                if (nodes[index].equals(none)) {
                    node.right = null;
                } else {
                    node.right = new TreeNode(Integer.parseInt(nodes[index]));
                    child.add(node.right);
                }
                index++;

            }
            list = child;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
