/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.List;
import java.util.ArrayList;
class Solution {

  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public List<Double> averageOfLevels(TreeNode root) {

        if (root == null) {
            return new ArrayList<Double>();
        }
        List<TreeNode> children = new ArrayList<TreeNode>();
        List<Double> result = new ArrayList<Double>();
        children.add(root);
        while (children.size() > 0) {
            double num = 0;
            List<TreeNode> list = new ArrayList<TreeNode>();
            for (int i = 0; i < children.size(); i++) {
                TreeNode node = children.get(i);
                num += node.val;
                if (node.left != null) {
                    list.add(node.left);
                }
                if (node.right != null) {
                    list.add(node.right);
                }
            }
            result.add(num / children.size());
            children = list;
        }
        return result;

    }
}
