/*Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?
*/

//算法：后续遍历二叉树，Java实现，递归的方式

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {

    List<Integer> postor(TreeNode root, List<Integer> result) {
        if (root != null) {
            result = postor(root.left, result);
            result = postor(root.right, result);
            result.add(root.val);
        }
        return result;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        result = postor(root, result);
        return result;
    }
}

//非递归的方式，栈顶元素，使用peek()
public class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        TreeNode p = root;
        TreeNode flag = null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (p != null || !stack.empty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.peek();
                if (p.right == null || p.right == flag) {
                    result.add(p.val);
                    stack.pop();
                    flag = p;
                    p = null;
                } else {
                    p = p.right;
                    flag = p;
                }
            }
        }
        return result;
    }
}
