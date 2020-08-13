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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        while(list.size() > 0) {
            List<Integer> nums = new ArrayList<Integer>();
            for (int i = 0; i<list.size(); i++) {
                TreeNode node = list.get(i);
                nums.add(node.val);
                if (node.left != null) {
                    list.add(node.left);
                }
                if (node.right != null) {
                    list.add(node.right);
                }
            }
            for (int i = 0; i < nums.size(); i++) {
                list.remove(0);
            }
            result.add(nums);
        }
        List<List<Integer>> out = new ArrayList<>();
        for (int i = 0; i < result.size(); i ++) {
            out.add(result.get(result.size() -1 - i));
        }
        return out;    
    }
}
