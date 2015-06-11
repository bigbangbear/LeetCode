/*Given a sorted array and a target value, return the index if the target is found. 
If not, return the index where it would be if it were inserted in order.
You may assume no duplicates in the array.
Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
/*
//该题属于简单的题目，在一个数组里遍历与目标数字进行比较，当当前数字大于等于目标数组时返回小标即可
class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        int n = nums.size();
        int i = 0;
        for(; i<n; i++){
            if(nums[i] >= target){
                return i;
            } 
        }
        return i;
    }
};