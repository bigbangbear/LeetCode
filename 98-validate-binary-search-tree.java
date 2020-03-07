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
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树
 *
 * 思路：前序列遍历所有节点，每个节点判断是否平衡
*/
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (isValidLeft(root.left, root.val) && isValidRight(root.right, root.val)){
            return isValidBST(root.left) && isValidBST(root.right);
        }else {
            return false;
        }

    }

    private boolean isValidLeft(TreeNode left, int max) {
        if (left == null) {
            return true;
        }
        if(left.val >= max) {
            return false;
        }
        return isValidLeft(left.left, max) && isValidLeft(left.right, max);
    }

    private boolean isValidRight(TreeNode right, int max) {
        if (right == null) {
            return true;
        }
        if(right.val <= max) {
            return false;
        }
        return isValidRight(right.left, max) && isValidRight(right.right, max);
    }
}

class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    private boolean isValid(TreeNode root, Integer min, Integer max) {
        if(root == null) {
            return true;
        }
        int val = root.val;
        if (min != null && min >= val) {
            return false;
        }
        if (max != null && max <= val){
            return false;
        }
        return isValid(root.left, min, val) && isValid(root.right, val, max);
    }
}

class Solution {
    private Integer min = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean isValid = isValidBST(root.left);
        if (!isValid) {
            return false;
        }
        if (min == null) {
            min = root.val;
        }else if (root.val <= min) {
            return false;
        }else {
            min = root.val;
        }
        return isValidBST(root.right);
    }
}
