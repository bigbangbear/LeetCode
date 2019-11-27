/**
 * 题目：返回数组中最接近目标值的三元组之和
 * 问题：用边界最大值会出现问题 Integer.MAX_VALUE + 1 越界出现问题
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for(int i=0; i<nums.length; i++){
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < Math.abs(result - target)){
                    result = sum;
                }
                if (sum > target) {
                    right--;
                }else if (sum < target) {
                    left++;
                }else{
                    return result;
                }
            }
        }
        return result;
    }
}
