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
        Map<Integer, Integer> map = buildInorderMap(inorder);
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    private Map<Integer, Integer> buildInorderMap(int[] inorder) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return map;
    }

    public TreeNode build(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight, Map<Integer, Integer> map) {
        if (preLeft > preRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft]);
        int inorderIndex = map.get(preorder[preLeft]);
        int leftSize = inorderIndex - inLeft;
        int rightSize = inRight - inorderIndex;
        if (leftSize > 0) {
            root.left = build(preorder, preLeft + 1, preLeft + leftSize, inorder, inLeft, inLeft + leftSize, map);
        }
        if (rightSize > 0){
            root.right = build(preorder, preLeft + leftSize + 1, preRight, inorder, inorderIndex + 1, inRight, map);
        }
        return root;
    }
}
