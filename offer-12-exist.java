/**
 * 思路：先找到这个值，然后回溯查询
 *
 */
class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        } 
        if (word == null || word.length() == 0) {
            throw new IllegalArgumentException("参数异常");
        }
        char first = word.charAt(0);

        for (int i = 0; i <bound.length; i++){
            for (int j = 0; j < bound[0].length; j++){
                if (first == board[i][j]) {

                }
            }
        }
        return false;
    }

    private boolean find(char [][] board, int i, int j, Set<String> path, int index, String word) {
        if (index >= word.length()){
            return true;
        }
        char c = word.charAt(index);
        if (c != board[i][j]) {
            return false;
        }
        String point = "row="+i+"column"+j;
        if (path.contains(point)){
            return false;
        }
        path.add(point);
        // 上
        if (i > 0) {
            boolean found = find(board, i-1, j,newSet(path), word, index+1);
            if (found){
                return true;
            } 
        }
        // 左
        if (j > 0) {
            boolean found = find(board, i, j-1,newSet(path), word, index+1);
            if (found){
                return true;
            } 
        }
        // 下
        if (i < board.length - 1) {
            boolean found = find(board, i+1, j,newSet(path), word, index+1);
            if (found){
                return true;
            } 
        }
        // 右 
        if (j < board[0].length - 1) {
            boolean found = find(board, i, j+1,newSet(path), word, index+1);
            if (found){
                return true;
            } 
        }
        return false;
    }
    private Set<String> newSet(Set<String> set) {
        Set<String> newSet = new HashSet<String>();
        newSet.addAll(set);
        return newSet;
    }
}


