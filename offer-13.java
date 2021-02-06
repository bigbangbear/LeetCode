class Solution {
        int result;
    public int movingCount(int m, int n, int k) {
        
        boolean used[][] = new boolean[m][n];
        move(m, n, k, 0, 0, used);
        return result;
    }

    public void move(int m, int n, int k, int i, int j, boolean[][] used) {
        if (i < 0 || i >= m || j < 0 || j >= n || used[i][j]) {
            return;
        }
        if (!canReach(i, j, k)) {
            return;
        }
        used[i][j] = true;
        result++;
        move(m, n, k, i-1, j, used);
        move(m, n, k, i + 1, j, used);
        move(m, n, k, i , j-1, used);
        move(m, n, k, i , j+1, used);
    }

    public boolean canReach(int i, int j, int k) {
       
        if (sum(i) + sum(j) <= k ) {
            return true;
        }
        return false;
    }

    public int sum(int i) {
        int sum = 0;
        while ( i > 0) {
            sum += (i % 10);
            i = i / 10;
        }
        return sum;
    }

}
