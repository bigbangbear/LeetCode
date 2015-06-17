/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
//递归的方式
class Solution {
public:

    void preorder(TreeNode *root, vector<int> *result){
        
        if(root){
            result->push_back(root->val);
            if(root->left) preorder(root->left, result);
            if(root->right) preorder(root->right, result);
        }else{
            return;
        }
    }
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> result;
        preorder(root, &result);
        return result;
    }
};

//利用栈实现非递归的调用，注意啦，是前序遍历，当该节点的左子树为空的时候，只要让指针指向栈顶元素的右子树，然后栈定元素pop即可
class Solution {
public:

    vector<int> preorderTraversal(TreeNode* root) {
        
        vector<int> result;
        TreeNode *p = root;
        stack<TreeNode *> s;
        while(p || !s.empty()){
            if(p){
                result.push_back(p->val);
                s.push(p);
                p = p->left;
            }else{
                p = s.top()->right;
                s.pop();
            }
        }
        return result;
    }
};