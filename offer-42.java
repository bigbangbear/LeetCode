class Solution {
    public int maxSubArray(int[] nums) {
            int max = Integer.MIN_VALUE;
    int pre = 0;
    for (int i=0; i<nums.length; i++) {
      int current = Math.max(pre + nums[i], nums[i]);
      max = Math.max(max, current);
      pre = current;
    }
    return max;
    }

