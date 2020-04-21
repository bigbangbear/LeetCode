class Main {
    public static void main(String[] args) {
        char[][] grid = new char[3][5];
        grid[0] = new char[]{'1','0','1','1','1'};
        grid[1] = new char[]{'1','0','1','0','1'};
        grid[2] = new char[]{'1','1','1','0','1'};
        Solution solution = new Solution();
        int num = solution.numIslands(grid);
        System.out.println(num);
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        int num = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '0') {
                    grid[i][j] = '2';
                }else if (grid[i][j] == '1') {
                    scan(grid, i, j);
                    num++;
                }
            }
        }
        return num;
    }

    private void scan(char[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length) {
            return;
        }
        if (y < 0 || y>= grid[0].length) {
            return;
        }
        if (grid[x][y] == '1') {
            grid[x][y] = '3';
            scan(grid,x-1, y);
            scan(grid, x+1, y);
            scan(grid, x, y-1);
            scan(grid, x, y+1);
        }
    }
}
