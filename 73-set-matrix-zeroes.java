/**
 * 题目：把二维数组中出现 0 的横竖都标记为0
 * 思路：先遍历记录下所有出现 0 的坐标，然后标记为 0
 */
class Solution {
    public void setZeroes(int[][] matrix) {

        Set<Integer> xPoints = new HashSet<Integer>();
        Set<Integer> yPoints = new HashSet<Integer>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    xPoints.add(i);
                    yPoints.add(j);
                }
            }
        }

        for (Integer index : xPoints) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[index][j] = 0;
            }
        }

        for (Integer index : yPoints) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][index] = 0;
            }
        }
    }
}
