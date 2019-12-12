/**
 * 查找出从左上角到右下角最大的路径
 * 思维总是惯性，再次尝试这道题目，还是依旧首先想到之前的解法，依旧走不通，尴尬！
 * 解法一：递归的方式，但是方法超时了
 * 那只能想办法用动态规划解决了！
 *
 */

/**
 *  递归的解法
 */
class Solution {
    private int rowLength;

    private int columnLength;

    private int min;

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        rowLength = grid.length;
        columnLength = grid[0].length;
        min = Integer.MAX_VALUE;
        scan(grid, 0, 0, 0);
        return min;
    }

    private void scan(int[][] grid, int row, int column, int sum) {
        if (sum > min || column >= columnLength || row >= rowLength) {
            return;
        }
        if (row == rowLength - 1 && column == columnLength - 1) {
            min = Math.min(grid[row][column] + sum, min);
        }
        if (row < rowLength) {
            scan(grid, row + 1, column, sum + grid[row][column]);
        }
        if (column < columnLength) {
            scan(grid, row, column + 1, sum + grid[row][column]);
        }
    }

}

/**
 *  递归公式：f(i, j) = min(f(i-1, j), f(i, j-1)) + grid[i][j]
 */
class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int[][] f = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    f[0][0] = grid[0][0];
                } else {
                    int f1 = (i - 1 < 0 ? Integer.MAX_VALUE : f[i - 1][j]);
                    int f2 = (j - 1 < 0 ? Integer.MAX_VALUE : f[i][j - 1]);
                    f[i][j] = Math.min(f1, f2) + grid[i][j];
                }
            }
        }
        return f[grid.length - 1][grid[0].length - 1];
    }
}
