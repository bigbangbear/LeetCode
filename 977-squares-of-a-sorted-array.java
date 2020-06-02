import java.lang.Math;

class Solution {
    public int[] sortedSquares(int[] A) {

        int[] result = new int[A.length];
        int left = 0; 
        int right = A.length - 1;
        int index = A.length - 1;
        while(left <= right) {
            if (Math.abs(A[left]) >= Math.abs(A[right])) {
                result[index] = A[left] * A[left];
                index--;
                left++;
            }else {
                result[index] = A[right] * A[right];
                right--;
                index--;
            }
        }
        return result;
    }

    public static void main(String[] args)  {
        int[] nums = new int[]{-3,-3,-2,1};
        Solution solution = new Solution();
        int result[] = solution.sortedSquares(nums);
        for(int i=0;i<result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
