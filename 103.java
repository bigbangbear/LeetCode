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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        boolean isLeft = true;
        if (root != null) {
            nodes.add(root);
        }
        while (nodes.size() > 0) {

            List<Integer> tmp = new ArrayList<Integer>();
            List<TreeNode> tmpNodes = new ArrayList<TreeNode>();

            for (int i = 0; i < nodes.size(); i++) {
                TreeNode node = null;
                if (isLeft){
                    node = nodes.get(i);
                }else{
                    node = nodes.get(nodes.size() - 1 - i);
                }
                tmp.add(node.val);
                if (node.left != null){
                    tmpNodes.add(nodes.get(i).left);
                }
                if (node.right != null){
                    tmpNodes.add(nodes.get(i).right);
                }
            }
            isLeft = !isLeft;
            nodes = tmpNodes;
            result.add(tmp);
        }
        return result;
    }

}
