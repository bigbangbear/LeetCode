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
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<TreeNode> parent = new ArrayList<>();
        List<TreeNode> child = new ArrayList<>();
        parent.add(root);
        while(parent.size() > 0) {
            child = getChild(parent);
            if (child.size() == 2 * parent.size()) {
                parent = child;
            }else {
                if (!isLeaf(child)) {
                    return false;
                }
                boolean isLeaf = true;
                for (TreeNode p: parent) {
                    if(isLeaf) {
                        if (p.left == null) {
                            if (p.right != null) {
                                return false;
                            }
                            isLeaf = false;
                        }else{
                            if (p.right == null) {
                                isLeaf = false;
                            }
                        }
                    }else{
                        if (p.left != null || p.right != null) {
                            return false;
                        }
                    }
                }
                return true;
            }
        }
        return true;
    }

    private boolean isLeaf(List<TreeNode> child) {
        for(TreeNode node: child) {
            if (node.left != null || node.right != null) {
                return false;
            }
        }
        return true;
    }

    private List<TreeNode> getChild(List<TreeNode> parent) {
        List<TreeNode> child = new ArrayList<>();
        for (TreeNode node: parent) {
            if (node.left != null) {
                child.add(node.left);
            }
            if (node.right != null) {
                child.add(node.right);
            }
        }
        return child;
    }
}
