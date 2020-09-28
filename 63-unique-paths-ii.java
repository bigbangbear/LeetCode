class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int dp[][] = new int[obstacleGrid.length + 1][obstacleGrid[0].length + 1];
        for (int i=1; i<= obstacleGrid.length; i++) {
            for (int j=1; j<= obstacleGrid[0].length; j++) {
                if (i == 1 && j == 1) {
                    dp[1][1] = 1 - obstacleGrid[0][0];
                }else {
                    if (obstacleGrid[i-1][j-1] == 1) {
                        dp[i][j] = 0;
                    }else {
                        dp[i][j] = dp[i-1][j] + dp[i][j-1];
                    }
                }
                System.out.print(" " + dp[i][j]);
            }
            System.out.println("");
        }
        return dp[obstacleGrid.length][obstacleGrid[0].length];
    }
}
