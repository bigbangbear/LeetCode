class Solution {
    public int findMaxForm(String[] strs, int m, int n) {

        int[][][] dp = new int[strs.length+1][m+1][n+1];
        Map<String, Integer> map = new HashMap<>();
        parse(strs, map);
        for (int i=1; i<= strs.length; i++) {
            int needM = map.get(getKey(i-1, 0));
            int needN = map.get(getKey(i-1, 1));
            for (int j=0; j <= m; j++) {
                for (int k=0; k<= n; k++) {
                    if (j < needM || k < needN) {
                        dp[i][j][k] = dp[i-1][j][k];
                    }else {
                        dp[i][j][k] = Math.max(dp[i-1][j - needM][k - needN] + 1, dp[i-1][j][k]);
                    }
                }
            }
        }

        return dp[strs.length][m][n];
    }

    private void parse(String[] strs, Map<String, Integer> map) {
        for (int i=0; i<strs.length; i++) {
            int one = 0;
            int zore = 0;
            for (int j=0; j<strs[i].length(); j++) {
                char c = strs[i].charAt(j);
                if (c == '1') {
                    one++;
                }else {
                    zore++;
                }
            }
            map.put(getKey(i, 0), zore);
            map.put(getKey(i, 1), one);
        }
    }

    private String getKey(int i, int num) {
        return i + "-" + num;
    }


}
