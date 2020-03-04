/**
 * 1. 思路：二分查找。先在第一行找到区间。然后，在列内找
 * 2. 测试：1. 数组为空  2. 数组只有一行 一列。3. 行就没有找到
 */
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        for (int i = 0; i < matrix[0].length; i++){
            if (findInColumn(matrix, target, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean findInColumn(int[][] matrix, int target, int column){
        int first = 0;
        int last = matrix.length - 1;
        while(first <= last) {
            int mid = (first + last) / 2;
            if (matrix[mid][column] == target ) {
                return true;
            }else if (matrix[mid][column] < target){
                first = mid + 1;
            }else if (matrix[mid][column] > target){
                last = mid - 1;
            }
        }
        return false;
    }
}

/**
 * 思路：从右上角开始找
 */
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = 0;
        int col = matrix[0].length - 1;
        while(row < matrix.length && col >= 0 ){
            int num = matrix[row][col];
            if (num == target){
                return true;
            }else if (num < target){
                row++;
            }else if (num > target){
                col--;
            }
        }
        return false;
    }
}
