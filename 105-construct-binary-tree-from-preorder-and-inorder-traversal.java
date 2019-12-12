/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 题目：根据前序跟中序构建二叉树
 * preorder = [3,9,20,15,7]
 *  inorder = [9,3,15,20,7]
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, preorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);
        if (preLeft < preRight) {
            int index = 0;
            for (int i = inLeft; i <= inRight; i++) {
                if (inorder[i] == rootVal) {
                    index = i;
                    break;
                }
            }
            root.left = build(preorder, inorder, preLeft +1, index, inLeft, index - 1);
            root.right = build(preorder, inorder, index +1, inRight, index + 1, inRight);
        }

        return root;
    }
}
