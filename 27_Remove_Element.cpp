class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int n = nums.size();
        
        for(int i=0; i<n;){
            int tmp = nums[i];
            if(tmp == val){
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