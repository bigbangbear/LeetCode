/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 * 解法思路一：前序遍历二叉树，保存在数组上，然后再平铺出来
 */
class Solution {
    public void flatten(TreeNode root) {

        List<TreeNode> list = new ArrayList<TreeNode>();
        scan(root, list);

        for(int i=1; i<list.size(); i++){
            TreeNode pre = list.get(i-1);
            TreeNode current = list.get(i);
            pre.right = current;
            pre.left = null;
        }

    }

    private void scan(TreeNode root, List<TreeNode> list) {
        if (root != null){
            list.add(root);

            scan(root.left, list);
            scan(root.right, list);
        }
    }
}
