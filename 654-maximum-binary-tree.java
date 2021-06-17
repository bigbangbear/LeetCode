/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return construct(nums, 0, nums.length - 1);
    }

    // [3,2,1,6,0,5]
    private TreeNode construct(int[]nums, int left, int right) {
        int max = nums[left];
        int index = left;
        for (int i = left+1; i <= right; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(max);
        if (index - 1 >= left) {
            root.left = construct(nums, left, index - 1);
        }
        if (index + 1 <= right) {
            root.right = construct(nums, index + 1, right);
        }
        return root;
    }
}
