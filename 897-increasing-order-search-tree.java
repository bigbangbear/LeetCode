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
   
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<TreeNode> list = new ArrayList<TreeNode>();
        mid(root, list);
        for(int i = 0; i < list.size() - 1; i++) {
            list.get(i).right = list.get(i+1);
            list.get(i).left = null;
        }
        return list.get(0);
    }

    public void mid(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        mid(root.left, list);
        list.add(root);
        mid(root.right,list);
    }

}
