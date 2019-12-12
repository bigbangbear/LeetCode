/**
 * 题目：判断一个字符串是否可以由多个单词组成
 * 思路：递归判断，但是时间超时了
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        if (s == null || s.length() == 0) {
            return true;
        }
        for (String word : wordDict) {
            if (s.length() >= word.length()) {
                String sub = s.substring(0, word.length());
                if (sub.equals(word)) {
                    boolean isBreak = wordBreak(s.substring(word.length(), s.length()), wordDict);
                    if (isBreak) {
                        return true;
                    }
                }
            }
        }
        return false;

    }
}

/**
 * 题目：判断一个字符串是否可以由多个单词组成
 * 思路：利用 DP 的方法 f(i) = f(j) + s
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (f[j] && wordDict.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[s.length()];

    }
}
