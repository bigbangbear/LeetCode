/**
 * 思路：求出每个点，左右的最高值
 */
class Solution {
    public int trap(int[] height) {
        int sum = 0;
        int left = 0;
        for (int i = 0; i < height.length; i++) {
            int right = 0;
            for (int j = i+1; j < height.length; j++) {
                right = Math.max(right, height[j]);
            }
            if (left > height[i] && right > height[i]) {
                sum += (Math.min(left, right) - height[i]);
            }
            left = Math.max(left, height[i]);
            System.out.println("height = " + height[i] +"left =" + left + ", right =" + right + ", sum = " + sum );
        }
        return sum;
    }
}

class Main {
    public static void main(String[] args) {
        int[] height = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        Solution solution = new Solution();
        int sum = solution.trap(height);
        System.out.println(sum);
    }
}
