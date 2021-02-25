public class Solution {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        int h = matrix.length;
        int w = matrix[0].length;
        int[] result = new int[h * w];
        int time = scanTimes(h, w);
        int index = 0;
        for (int i = 0; i < time; i++) {
            int maxW = w - i - 1;
            int maxH = h - i - 1;
            // 不形成环
            if (maxH - i == 0) {
                for (int j=i; j<=maxW; j++) {
                    result[index] = matrix[i][j];
                    index++;
                }
                break;
            }
            if (maxW  - i == 0) {
                for (int j=i; j<= maxH; j++) {
                    result[index] = matrix[j][i];
                    index++;
                }
                break;
            }

            // 形成环
            // 上
            for (int j=i; j < maxW; j++) {
                result[index] = matrix[i][j];
                index++;
            }
            // 右
            for (int j=i; j < maxH; j++) {
                result[index] = matrix[j][maxW];
                index++;
            }
            // 下
            for (int j=maxW; j > i; j--) {
                result[index] = matrix[maxH][j];
                index++;
            }
            // 左
            for (int j=maxH; j>i; j--) {
                result[index] = matrix[j][i];
                index++;
            }
       }
        return result;
    }

    private int scanTimes(int h,int w) {
        h = Math.min(w, h);
        if (h % 2 == 0) {
            return h / 2;
        } else {
            return h / 2 + 1;
        }
    }
}

