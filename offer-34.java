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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<>();
        help(root, sum, 0, result, new ArrayList<>());
        return result;
    }

    public void help(TreeNode root, int sum, int c, List<List<Integer>> result, List<Integer> path) {
        if (root == null) {
            return;
        }
        c += root.val;
        path.add(root.val);
        if (root.left == null && root.right == null && c == sum) {
            result.add(new ArrayList<>(path));
        }
        help(root.left, sum, c, result, path);
        help(root.right, sum, c, result, path);
        path.remove(path.size()-1);
    }
}
