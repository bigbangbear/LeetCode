/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 问题一：Java 参数问题：值传递还是引用传递
 */
class Solution {
    private int minDepth = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getLeafDepth(root, 1);
        return minDepth;
    }

    public void getLeafDepth(TreeNode root, int depath) {
        if (minDepth < depath || root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            minDepth = Math.min(minDepth, depath);
        } else {
            depath++;
            getLeafDepth(root.left, depath);
            getLeafDepth(root.right, depath);
        }
    }

}
