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
 * 思路：后续遍历，对每个节点进行前序遍历，如果找到两个节点，则返回当前节点
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return postOrder(root, p, q);
    }

    public TreeNode preOrder(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> sum) {
        if(root == null){
            return null;
        }
        if (root == p || root == q) {
            sum.add(root);
        } 
        preOrder(root.left, p, q, sum);
        preOrder(root.right, p, q, sum);
        if (sum.size() >= 2) {
            return root;
        }else{
            return null;
        }
    }

    public TreeNode postOrder(TreeNode root, TreeNode p, TreeNode q){
        if (root == null){
            return null;
        }
        TreeNode result = null;
        result = postOrder(root.left, p, q);
        if (result != null){
            return result;
        }
        result = postOrder(root.right,p,q);
        if (result != null){
            return result;
        }
        return preOrder(root, p, q, new ArrayList<>()); 
    }
}

class Solution {

    private Map<TreeNode, TreeNode> parent = new HashMap<>();
    private Map<TreeNode, Boolean> visited = new HashMap<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p != null) {
            visited.put(p, true);
            p = parent.get(p);
        }
        while (q != null) {
            if (visited.containsKey(q)) {
                return q;
            }
            q = parent.get(q);
        }
        return null;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            parent.put(root.left, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right, root);
            dfs(root.right);
        }
    }

}


