/*Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].
*/

//递归的方式
public class Solution {
    
    public List<Integer> preorder(TreeNode root, List<Integer> result){
        
        if(root != null){
            result.add(root.val);
            preorder(root.left, result);
            preorder(root.right, result);
        }
        return result;
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> result = new  ArrayList<Integer>();
        
        return preorder(root, result);
    }
}

//非递归的方式
public class Solution {
    
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList<Integer>();
        
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while(p != null  || !stack.empty()){
            
            if(p != null){
                result.add(p.val);
                stack.push(p);
                p = p.left;
            }else{
                p = stack.pop().right;
                if(p.right != null){
                    p = p.right;
                }else{
                    p = null;
                }
            }
            
        }
        
        return result;
        
    }
}