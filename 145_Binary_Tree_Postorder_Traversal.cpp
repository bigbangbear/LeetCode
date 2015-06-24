// 145_Binary_Tree_Postorder_Traversal 
//算法思想：后根遍历二叉树
//递归的方式

class Solution {
public:

    void postorder(TreeNode *root, vector<int> &result){
        
        if(root != NULL){
            postorder(root->left, result);
            postorder(root->right, result);
            result.push_back(root->val);
        }else{
            return;
        }
    }
    vector<int> postorderTraversal(TreeNode* root) {
        vector<int> result;
        postorder(root, result);
        return result;
    }
};

//非递归方式，通过标志位，当起右子树访问过的时候，栈顶元素抛出
class Solution {
public:

    vector<int> postorderTraversal(TreeNode* root) {
        vector<int> result;
        TreeNode *p = root;
        TreeNode *last = NULL;
        stack<TreeNode *> stack;
        
        while(p != NULL || !stack.empty()){
            if(p != NULL){
                stack.push(p);
                p = p->left;
            }else{
                p = stack.top();
                if(p->right == NULL || p->right == last){
                    result.push_back(p->val);
                    last = p; 
                    stack.pop();
                    p = NULL;
                }else{
                    p = p->right;
                }
            }
        }
        
        return result;
    }
};