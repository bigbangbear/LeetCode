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
        if (root == null) {
            return Collections.emptyList();
        }
        List<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(list, result);
        return result;
    }

    private void helper(List<TreeNode> list, List<List<Integer>> result) {
        if (list == null || list.size() == 0) {
            return;
        }
        List<TreeNode> children = new ArrayList<TreeNode>();
        List<Integer> resultList = new ArrayList<Integer>();
        for (TreeNode node : list){
            resultList.add(node.val);
            if (node.left != null) {
                children.add(node.left);
            }
            if (node.right != null){
                children.add(node.right);
            }
        }
        result.add(resultList);
        helper(children, result);
    }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(result, root, 1);
        return result;
    }

    private void helper(List<List<Integer>> result, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (result.size() < level) {
            List<Integer> list = new ArrayList<Integer>();
            result.add(list);
        }
        List<Integer> nums = result.get(level-1);
        nums.add(root.val);
        helper(result, root.left, level + 1);
        helper(result, root.right, level + 1);
    }
}
