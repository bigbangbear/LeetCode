/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 题目：有序的数组转化为平衡二叉树
 * 注意：如何往平衡二叉树中插入新的节点。LL LR RR RL
 *
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        TreeNode root = null;
        while(head != null) {
            root = addNode(root, head.val);
            head = head.next;
        }
        return root;
    }

    private TreeNode addNode(TreeNode root, int value) {
        TreeNode node = new TreeNode(value);
        if (root == null) {
            return node;
        }
        // 找到对应的位置插入
        insert(root, root, node); 
        // 转化为平衡二叉树
        return bst(root);
    }

    private int depth(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        } 
        int left = depth(root.left, depth + 1);
        int right = depth(root.right, depth + 1);
        return Math.max(left, right);
    }

    private TreeNode bst(TreeNode root) {
        if (root == null) {
            return null;
        }
        int left = depth(root.left, 0);
        int right = depth(root.right, 0);
        boolean isBst = Math.abs( left - right) <= 1;
        if (!isBst){
            if (left < right){
                TreeNode newRoot = root.right;
                TreeNode leftNode = root.right;
                root.right = null;
                while(leftNode.left != null){
                    leftNode = leftNode.left;
                }
                leftNode.left = root;
                root = newRoot;
            }else {
                TreeNode newRoot = root.left;
                TreeNode rightNode = root.left;
                root.left = null;
                while(rightNode.right != null){
                    rightNode = rightNode.right;
                }
                rightNode.right = root;
                root = newRoot;
            }
        }
        root.left = bst(root.left);
        root.right = bst(root.right);
        return root;
    }

    private void insert(TreeNode root,TreeNode parent, TreeNode node) {
        if (node.val < root.val) {
            if (root.left == null){
                root.left = node;
            }else{
                insert(root.left, root,  node);
            }
        }else {
            if (root.right == null) {
                root.right = node;
            }else{
                insert(root.right,root,  node);
            }
        }
    }

}
