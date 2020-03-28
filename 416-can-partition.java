class Main {
    public static void main(String[] args) {
        int [] nums = new int[4];
        nums[0] = 0;
        nums[1] = 2;
        nums[2] = 8;
        nums[3] = 10;
        Solution solution = new Solution();
        boolean can = solution.canPartition(nums);
        System.out.println("can" + can);
    }
}
class Solution {
    public boolean canPartition(int[] nums) {
        int s = sum(nums);
        if (s == 0) {
            return true;
        }
        if (s % 2 != 0) {
            return false;
        }
        int target = s / 2;
        boolean[][] dp = initDp(target,  nums.length);
        for(int i=1; i <= target; i++){
            for(int j=1; j<= nums.length; j++) {
                boolean selected = false;
                if ((i - nums[j-1]) >= 0) {
                    selected = dp[i - nums[j-1]][j-1];
                }
                boolean unselected = dp[i][j - 1];
                dp[i][j] =(selected || unselected); 
                System.out.print(dp[i][j] + " ");
            }
            System.out.println("");
        }
        return dp[target][nums.length];
    }

    private boolean[][] initDp(int target, int nums) {
        boolean[][] dp = new boolean[target + 1][nums + 1];
        for (int i = 0; i < nums; i++) {
            dp[0][i] = true;
        }
        return dp;
    }

    private int sum(int[] nums) {
        int sum = 0;
        for (int num : nums){
            sum += num;
        }
        return sum;
    }
}
