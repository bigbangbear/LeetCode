/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.List;
import java.util.ArrayList;

class Solution {

  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        help(root, result, path, sum);
        return result;
    }

    public void help(TreeNode root, List<List<Integer>> result, List<Integer> path, int sum) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        help(root.left, result,path, sum - root.val);
        help(root.right, result,path, sum - root.val);
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                List<Integer> tmp = new ArrayList<Integer>(path);
                result.add(tmp);
            }
        }
        path.remove(path.size() - 1);
    }
}
