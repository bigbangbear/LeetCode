/**
 * 判断一棵树是不是平衡二叉树
 * 平衡二叉树的定义：是一棵空树，或者左右子树的高度差不超过一
 * 注意点：
 *    (1)思维的惯性，做错的事情，过了一段时间后就会忘记，还是重复犯错！
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    /**
     * 遍历每一个节点，判断左右子树的高度是否平衡
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        if (isSubBalanced(root.left, root.right)){
            return isBalanced(root.left) && isBalanced(root.right);
        }else{
            return false;
        }
    }

    /**
     * 判断当前树，左右子树的高度差是否小于等于1
     */
    public boolean isSubBalanced(TreeNode left, TreeNode right){
        int leftHeight = height(left, 0);
        int rightHeight = height(right, 0);
        return Math.abs(leftHeight - rightHeight) <= 1;

    }

    /**
     * 获取树的高度
     */
    public int height(TreeNode root, int depth){
        if (root == null){
            return depth;
        }else{
            return Math.max(height(root.left, depth+1), height(root.right, depth+1));
        }
    }

}
