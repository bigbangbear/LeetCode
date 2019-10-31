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
    public boolean isSymmetric(TreeNode root) {

        if (root == null){
            return true;
        }
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {
        if (left == null || right == null){
            return left == right;
        }
        if (left.val == right.val){
            if (compare(left.left, right.right) && compare(left.right, right.left)){
                return true;
            } 
        }
        return false;
    }
}
