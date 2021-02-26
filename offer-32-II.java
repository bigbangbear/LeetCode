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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<TreeNode> child = new ArrayList<>();
        child.add(root);
        while(child.size() > 0) {
            List<Integer> tmp = new ArrayList<Integer>();
            List<TreeNode> subChild = new ArrayList<>();
            for (int i=0; i<child.size(); i++) {
                TreeNode node = child.get(i);
                tmp.add(node.val);
                if (node.left != null) {
                    subChild.add(node.left);
                }
                if (node.right != null) {
                    subChild.add(node.right);
                }
            }
            result.add(tmp);
            child = subChild;
        }
        return result;
    }
}
