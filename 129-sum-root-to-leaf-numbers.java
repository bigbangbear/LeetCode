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
  private int sum = 0;

    public int sumNumbers(TreeNode root) {

        if (root == null) {
            return 0;
        }
        helper(root, 0);
        return sum;
    }

    public void helper(TreeNode root, int path) {

        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            sum += (path * 10 + root.val);
            return;
        }
        helper (root.left, path * 10 + root.val);
        helper (root.right, path * 10 + root.val);
    }
}
