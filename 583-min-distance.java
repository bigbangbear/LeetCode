//给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。 
//
// 
//
// 示例： 
//
// 输入: "sea", "eat"
//输出: 2
//解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"
// 
//
// 
//
// 提示： 
//
// 
// 给定单词的长度不超过500。 
// 给定单词中的字符只含有小写字母。 
// 
// Related Topics 字符串 
// 👍 182 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word1.isEmpty()) {
            return word2.length();
        }
        if (word2 == null || word2.isEmpty()) {
            return word1.length();
        }
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i=1; i<=word1.length(); i++) {
            for (int j=1; j<=word2.length(); j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else {
                    dp[i][j]  = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int sameLen = dp[word1.length()][word2.length()];
        return word1.length() - sameLen + word2.length() - sameLen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

