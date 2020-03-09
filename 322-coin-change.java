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
