/**
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
//算法思想，遍历二叉树，遇到根节点的时候判断是非路径上节点的和等于目标数值
class Solution {
public:

    void traverse(TreeNode* p,int tmpSum, int sum, bool &result){
        if(p != NULL){
            tmpSum += p->val;
            if(p->left == NULL && p->right == NULL){
                if(tmpSum == sum) result = true;
                return;
            }else{
                traverse(p->left, tmpSum, sum, result);
                traverse(p->right, tmpSum, sum, result);
            }
        }
    }
    bool hasPathSum(TreeNode* root, int sum) {
        bool result = false;
        int tmpSum = 0;
        traverse(root, tmpSum, sum, result);
        return result;
    }
};