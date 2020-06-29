import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
class Solution {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int result = 0;
        int num = 1;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            num *= nums[right];
            while (num >= k && left <= right) {
                num /= nums[left];
                left++;
            }
            result += right - left + 1;
        }
        return result;
    }


    public static void main(String args[])  {

        int [] nums = new int[] {10,5,2,6};
        Solution solution = new Solution();
        int result = solution.numSubarrayProductLessThanK1(nums, 100);
        System.out.println(result);
    }
}
