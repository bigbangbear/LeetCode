/**
 * 
 */
class Solution {

    private int max = -1;

    public int maxDistance(int[][] grid) {

        int[][] distance = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                int tmp = help(grid, distance, i, j);
                max = Math.max(max, tmp);
            }
        }
        return max;
    }

    private int help(int[][] grid, int[][] distance, int i, int j) {
        int tmp = 0;
        if (j - 1 >= 0) {
            if (grid[i][j-1] == 1) {
                return 1;
            }else{
                tmp = Math.min(tmp, distance[i][j-1] + 1);
            }
        }
        
        if (i - 1 >= 0) {
            if (grid[i-1][j] == 1) {
                return 1;
            }else {
                tmp = Math.min(tmp, distance[i-1][j]);
            }
        }

        if ()


        return -1;
    }
}
