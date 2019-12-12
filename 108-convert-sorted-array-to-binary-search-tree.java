/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 解题：根据数组返回一棵高度平衡的二叉搜索树
 *     没有想出来怎么解决该问题，看了提示，接口平衡树的特点左右子树的高度相同，所以取中间作为根节点
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {

        if (nums == null || nums.length == 0) {
            return null;
        }
        return midTree(nums, 0, nums.length - 1);

    }

    private TreeNode midTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        TreeNode left = midTree(nums, start, mid - 1);
        TreeNode right = midTree(nums, mid + 1, end);
        node.left = left;
        node.right = right;
        return node;
    }

}
