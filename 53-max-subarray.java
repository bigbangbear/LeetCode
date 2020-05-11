class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int [] dp = new int[nums.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (i == j) {
                    dp[i] = nums[i];
                }else {
                    dp[j] = dp[j-1] + nums[j];
                }
                max = Math.max(max, dp[j]);
            }
        }
        return max;    
    }

    public static void main(String[] args)  {
        int [] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        Solution solution = new Solution();
        int max = solution.maxSubArray(nums);
        System.out.println("max" + max);
    }
}
