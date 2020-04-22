/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        List<Integer> result = new ArrayList<Integer>();
        List<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        help(result, list);
        return result;
    }

    private void help(List<Integer> result, List<TreeNode> list) {
        if (!list.isEmpty()) {
            TreeNode node = list.get(list.size() - 1);
            result.add(node.val);

            List<TreeNode> children = new ArrayList<TreeNode>();
            for(int i = 0; i < list.size(); i++) {
                TreeNode child = list.get(i);
                if (child.left != null) {
                    children.add(child.left);
                }
                if (child.right != null) {
                    children.add(child.right);
                }
            }
            help(result, children);
        }
    }
}

