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
 * 思路：前序遍历所有节点，从该节点开始再次前序遍历所有的节点计算路径上的最大值
 */
class Solution {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int left = max(root.left);
        int right = max(root.right);
        max = Math.max(max, root.val);
        if (left != Integer.MIN_VALUE) {
            max = Math.max(max, root.val + left);
        }
        if (right != Integer.MIN_VALUE) {
            max = Math.max(max, root.val + right);
        }
        if (right != Integer.MIN_VALUE && left != Integer.MIN_VALUE) {
            max = Math.max(max, left + right + root.val);
        }

        maxPathSum(root.left);
        maxPathSum(root.right);

        return max;
    }

    public int max(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int left = max(root.left);
        int right = max(root.right);

        int tmpMax = root.val;
        if (left != Integer.MIN_VALUE) {
            tmpMax = Math.max(tmpMax, root.val + left );
        }
        if (right != Integer.MIN_VALUE) {
            tmpMax = Math.max(tmpMax, root.val + right);
        }
        return tmpMax;
    }


}
