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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<TreeNode> child = new ArrayList<>();
        child.add(root);
        boolean left = true;
        while(child.size() > 0) {
            List<TreeNode> subChild = new ArrayList<>();
            for (TreeNode node: child) {
                if (node.left != null) {
                    subChild.add(node.left);
                }
                if (node.right != null) {
                    subChild.add(node.right);
                }
            }
            List<Integer> tmp = new ArrayList<>();
            if (left) {
                for (int i=0; i<child.size(); i++) {
                    tmp.add(child.get(i).val);
                }
            }else{
                for (int i=child.size()-1; i>=0; i--) {
                   tmp.add(child.get(i).val); 
                }
            }
            result.add(tmp);
            left = !left;
            child = subChild;
        }
        return result;
    }
}
