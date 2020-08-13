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
            List<TreeNode> children = new ArrayList<>();
            for (int i = 0; i<list.size(); i++) {
                TreeNode node = list.get(i);
                nums.add(node.val);
                if (node.left != null) {
                    children.add(node.left);
                }
                if (node.right != null) {
                    children.add(node.right);
                }
                System.out.print(nums.get(i));
            }
            list = children;

            result.add(nums);
            System.out.println("nums" + nums.toString());
        }
        List<List<Integer>> out = new ArrayList<>();
        for (int i = 0; i < result.size(); i ++) {
            out.add(result.get(result.size() -1 - i));
        }
        return out;    
    }
}
