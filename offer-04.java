
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            if (scan(matrix[i], target)) {
                return true;
            }
        }
        return false;
    }

    private boolean scan(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return true;
            }else if (nums[mid] < target) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        return false;
    }
}

class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int x=0;
        int y=matrix[0].length-1;
        while (x >= 0 && x<matrix.length && y >=0 && y<matrix[0].length) {
            //System.out.println(matrix[x][y]);
            if (matrix[x][y] == target) {
                return true;
            }else if (matrix[x][y] < target) {
                x++;
            }else {
                y--;
            }
        }
        return false;

    }
}
