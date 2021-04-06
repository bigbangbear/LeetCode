import java.util.*;

/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 * }
 */

public class Solution {
    /**
     * 
     * @param t1 TreeNode类 
     * @param t2 TreeNode类 
     * @return TreeNode类
     */
    public TreeNode mergeTrees (TreeNode t1, TreeNode t2) {
        // write code here
        if (t1 == null && t2 == null) {
            return null;
        } 
        TreeNode root = null;
        if (t1 == null) {
            root = t2;
            root.left = mergeTrees(null, t2.left);
            root.right = mergeTrees(null, t2.right);
        }else if(t2 == null){
            root = t1;
            root.left = mergeTrees(t1.left, null);
            root.right = mergeTrees(t1.right, null);
        }else {
            root = t1;
            t1.val = t1.val + t2.val;
            root.left = mergeTrees(t1.left, t2.left);
            root.right = mergeTrees(t1.right, t2.right);
        }
        return root;
    }
}
