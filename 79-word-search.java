class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
            return false;
        }
        boolean [][] used = new boolean[board.length][board[0].length];
        for (int i = 0; i <board.length; i++) {
            for (int j = 0; j <board[i].length; j++) {
                if (help(board, word, 0, i, j, used)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean help(char[][] board, String word, int index,int x, int y, boolean[][] used) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return false;
        }
        if (board[x][y] != word.charAt(index) || used[x][y] == true) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }

        used[x][y] = true;
        boolean found = help(board, word, index + 1, x -1, y, used)
            || help(board, word, index + 1, x + 1, y, used)
            || help(board, word, index + 1, x, y - 1, used)
            || help(board, word, index + 1, x, y + 1, used);
        if (!found) {
            used[x][y] = false;
        }
        return found;
    }

}
