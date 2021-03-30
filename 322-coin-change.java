/**
 * 思路: 凑零钱。dp(n) = 1 + min{dp(n - coin)}
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount <= 0) {
            return 0;
        }
        Map<Integer, Integer> dp = new HashMap<Integer, Integer>();
        dp.put(0, 0);
        for (int i = 1; i <= amount; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j <coins.length; j++) {
                int remian = i - coins[j];
                if (remian < 0) {
                    continue;
                }else if (remian >= 0 && dp.get(remian) >= 0) {
                    min = Math.min(min, 1 + dp.get(remian));
                }
            }
            if (min < Integer.MAX_VALUE) {
                dp.put(i, min);
            }else {
                dp.put(i, -1);
            }
        }
        return dp.get(amount);
    }
}


//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：coins = [1], amount = 1
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：coins = [1], amount = 2
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 231 - 1 
// 0 <= amount <= 104 
// 
// Related Topics 动态规划 
// 👍 1165 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 1 2 5 11
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (coins == null || coins.length == 0) {
            return -1;
        }
        int [] dp = new int[amount + 1];
        dp[0] = -1;
        for (int i=0; i<coins.length; i++) {
            int num = coins[i];
            if (num <= amount) {
                dp[num] = 1;
            }
        }
        for (int i=1; i<=amount; i++) {
            if (dp[i] == 1) {
                continue;
            }
            int num = -1;
            for (int coin: coins) {
                int pre = i - coin;
                if (pre > 0 && dp[pre] > 0) {
                    if (num == -1) {
                        num = dp[pre] + 1;
                    }else {
                        num = Math.min(num, dp[pre] + 1);
                    }
                }
            }
            dp[i] = num;
            System.out.println(dp[i]);
        }
        return dp[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
