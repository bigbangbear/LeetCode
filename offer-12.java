class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++){
                boolean[][] used = new boolean[board.length][board[0].length];
                if (help(board, used, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean help(char[][] board, boolean[][] used, String word, int x, int y, int index) {
       if (index == word.length()) {
            return true;
        }
        if (x < 0 || x >= board.length || y <0 || y >= board[0].length) {
            return false;
        }
        if (used[x][y] || board[x][y] != word.charAt(index)) {
            return false;
        }
        used[x][y] = true;
        if (help(board, used, word, x + 1, y, index + 1) ||
                help(board, used, word, x - 1, y, index + 1) ||
                help(board, used, word, x, y+1, index+1) ||
                help(board, used, word, x, y-1, index+1)
        ) {
            return true;
        }
        used[x][y] = false;
        return false;
    }
}
