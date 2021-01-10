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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        return build(preorder, inorder, 0, preorder.length -1, 0, preorder.length -1);

    }

    private TreeNode build(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        int val = preorder[preLeft];
        TreeNode root = new TreeNode(val);
        int valInIndex = inLeft;
        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i] == val) {
                valInIndex = i;
                break;
            }
        }
        int leftLength = valInIndex - inLeft;
        int rightLength = inRight - valInIndex;
        if (leftLength > 0) {
            root.left = build(preorder, inorder, preLeft  + 1, preLeft + leftLength, inLeft, valInIndex - 1);
        }
        if (rightLength > 0) {
            root.right = build(preorder, inorder, preRight - rightLength + 1, preRight, valInIndex +1, inRight);
        }
        return root;

    }

    
}
