import java.lang.Math;

/**
 * Definition: 递归
 */
class Solution {
    public int massage(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            // 选择
            int selected = nums[i];
            if (i - 2 >= 0) {
                selected += dp[i - 2];
            }
            // 不选择
            int unselected = 0;
            if (i - 1 >= 0) {
                unselected = dp[i - 1];
            }
            dp[i] = Math.max(selected, unselected);
        }
        return dp[nums.length - 1];
    }
}

class Main {
    public static void main(String[] args) {
        int [] nums = new int[4];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 3;
        nums[3] = 1;
        Solution solution = new Solution();
        int sum = solution.massage(nums);
        System.out.println("sum" + sum);
    }
}
