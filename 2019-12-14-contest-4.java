/**
 * Definition: 二维数组中返回下降路径长度最小的和。注意相邻行不能同列
 * 动态规划解法
 */
class Solution {
     public int minFallingPathSum(int[][] arr) {
        
        int [][] sum = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++){
                if (i == 0) {
                    sum[i][j] = arr[0][j];
                }else{
                    sum[i][j] = arr[i][j] + min(sum, i-1, j);
                }
            }
        }
        return min(sum, arr.length-1, -1);
    }

    private int min(int[][] sum, int row, int column) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < sum[0].length; i++){
            if (i != column) {
                min = Math.min(min, sum[row][i]);
            }
        }
        return min;
    }

}
