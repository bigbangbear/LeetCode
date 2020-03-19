/**
 * 题目：求最大公共子序列
 * 测试：text1 = "abcde", text2 = "ace"
 */
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int maxLength = 0;
        if (text1 == null || text2 == null) {
            return maxLength;
        }
        if (text1.length() == 0 || text1.length() == 0){
            return maxLength;
        }
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++){
            for (int j = 1; j <= text2.length(); j++){
                char c1 = text1.charAt(i-1);
                char c2 = text2.charAt(j-1);
                if (c1 == c2) {
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    int max = Math.max(dp[i-1][j], dp[i][j-1]);
                    dp[i][j] = max;
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }
}

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.longestCommonSubsequence("bmvcnwrmxcfcxabkxcvgbozmpspsbenazglyxkpibgzq", "bmpmlstotylonkvmhqjyxmnqzctonqtobahcrcbibgzgx");
        System.out.println(result);
    }
}
