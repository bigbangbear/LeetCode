class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int[][] result = new int[board.length + 2][board[0].length + 2];

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                result[i+1][j+1] = board[i][j];
            }
        }

        for (int i = 1; i <= board.length; i++){
            for (int j = 1; j <= board[0].length; j++){
                int sum = 0;
                sum += result[i-1][j];
                sum += result[i-1][j-1];
                sum += result[i-1][j+1];
                sum += result[i][j-1];
                sum += result[i][j+1];
                sum += result[i+1][j-1];
                sum += result[i+1][j];
                sum += result[i+1][j+1];

                if (result[i][j] == 0 && sum == 3) {
                    board[i-1][j-1] = 1;  
                }
                if (result[i][j] == 1) {
                    if (sum < 2) {
                        board[i-1][j-1] = 0;
                    }
                    if (sum == 2 || sum == 3) {

                   }
                    if (sum > 3) {
                        board[i-1][j-1] = 0;
                    }
                }
            }
        }
    }
}
