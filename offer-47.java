class Solution {
    public int maxValue(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int [][] dp = new int[grid.length+1][grid[0].length+1];
        for (int i = 0; i<grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dp[i+1][j+1] = Math.max(dp[i-1+1][j+1] + grid[i][j], dp[i+1][j-1+1] + grid[i][j]);
            }
        }
        return dp[grid.length][grid[0].length];

    }
}}
