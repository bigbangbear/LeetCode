/*
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
*/
//算法思想，回溯法，树的深度递归的思想，遍历所有可能的解，利用递归来实现。回溯法的主要思想就是树的深度递归


class Solution {
public:

   void combination(vector<int> tmp, vector<int> candidates, int n, int sum, int target, vector<vector<int>> &result){

    while(sum  <= target){
        
        if(sum == target){
            sort(tmp.begin(), tmp.end());
            result.push_back(tmp);
        }else{
            if(n < candidates.size()-1){
                combination(tmp, candidates, n+1,sum, target, result);
            }
        }

        tmp.push_back(candidates[n]);
        sum += candidates[n];
    }
}
vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
    vector<vector<int>> result;
    vector<int> tmp;
    int n = candidates.size();
    int sum = 0;
    combination(tmp, candidates, 0, sum, target, result);
    return result;
}
};