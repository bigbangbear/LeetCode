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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        List<Integer> result = new ArrayList<Integer>();
        getTreeElements(root1, result);
        getTreeElements(root2, result);
        Collections.sort(list);
        return result;
    }

    public void getTreeElements(TreeNode root, List<Integer> list){
        if (root != null) {
            list.add(root.val);
            getTreeElements(root.left, list);
            getTreeElements(root.right, list);
        }
    }
}
