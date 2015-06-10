//这段题目较为简单，是将一个数组里剔除关键数字，并且返回最后的长度，算法思想，找到关键数字后将后面的数字往前移动一位，长度减一即可
class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int n = nums.size();
        
        for(int i=0; i<n;){
            if(nums[i] == val){
                for(int j=i+1; j<n; j++){
                    nums[j-1] = nums[j];
                }
                n--;
            }else{
                i++;
            }
        }
        
        return n;
    }
};
