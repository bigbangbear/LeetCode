/** Binary Tree Level Order Traversal
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 */
//算法思想，二叉树的按层遍历，我通过递归的方式实现如下
class Solution {
public:

    void level(vector<TreeNode *> presentLevel, vector<vector<int>> &result){
        vector<int> tmp;
        vector<TreeNode *> tmpTreeNode;
        
        int n = presentLevel.size();
        if(n <= 0) return;
        for(int i=0; i<n; i++){
            tmp.push_back(presentLevel[i]->val);
            if(presentLevel[i]->left != NULL){
                tmpTreeNode.push_back(presentLevel[i]->left);
            }
            if(presentLevel[i]->right != NULL){
                tmpTreeNode.push_back(presentLevel[i]->right);
            }
        }
        result.push_back(tmp);
        level(tmpTreeNode, result);
    }
    vector<vector<int>> levelOrder(TreeNode* root) {
        
        vector<vector<int>> result;
        vector<TreeNode*> firstLevel;
        
        if(root != NULL){
            firstLevel.push_back(root);
            level(firstLevel, result);
        }
        
        return result;
        
    }
};

//利用递归的思想，通过栈来实现，非递归的方式，用另外一个队列来保存孩子节点层
class Solution {
public:

    vector<vector<int>> levelOrder(TreeNode* root) {
        
        vector<vector<int>> result;
        vector<TreeNode*> level;
        
        if(root != NULL){
            level.push_back(root);
        }
        while(level.size() > 0){
            vector<int> tmp;
            vector<TreeNode*> nextLevel;
            for(int i=0; i<level.size(); i++){
                tmp.push_back(level[i]->val);
                if(level[i]->left != NULL){
                    nextLevel.push_back(level[i]->left);
                }
                if(level[i]->right != NULL){
                    nextLevel.push_back(level[i]->right);
                }
            }
            result.push_back(tmp);
            level = nextLevel;
        }
        
        return result;
        
    }
};