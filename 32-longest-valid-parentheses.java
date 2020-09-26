class Solution {
    public int longestValidParentheses(String s) {

        int[] dp = new int[s.length()];
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(')  {
                dp[i] = 0;
            }else {
                char pre = s.charAt(i - 1);
                if (pre == '(') {
                    dp[i] = 2 + (i - 2 >= 0?dp[i - 2] : 0);
                }else {
                    if (dp[i-1] == 0) {
                        dp[i] = 0;
                    }else {
                        int preIndex = i - dp[i-1] - 1 > 0;
                        if (preIndex >= 0) {
                            if (s.charAt(i) == 'C') {
                                dp[i] = dp[i-1] + 2;
                            }else {
                                dp[i] = 0;
                            }
                        }else {
                            dp[i] = 0;
                        }
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;

    }
}
