class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        for (int i=1; i<= s.length(); i++) {
            System.out.println((i - 1) + " " + dp[i-1]);
            int num = s.charAt(i-1) - '0';
            if (i == 1) {
                if (num == 0) {
                    return 0;
                }else {
                    dp[i] = 1;
                }
                continue;
            }
            int pre = s.charAt(i - 2) - '0';
            if (num == 0) {
                if (pre <= 0 || pre > 2) {
                    return 0;
                }else{
                    dp[i] = dp[i - 2];
                    continue;
                }
            }
            if (num < 7) {
                if (pre <= 2) {
                    dp[i] = dp[i - 1] + 1;
                }else {
                    dp[i] = dp[i - 1];
                }
            }else {
                if (pre == 1) {
                    dp[i] = dp[i - 1] + 1;
                }else{
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.numDecodings("2611055971756562");
        System.out.println(result);
    }
}
