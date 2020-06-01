import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i ++) {
            int right = target - nums[i];
            for (int j = i + 1; j < nums.length; j ++) {
                if (nums[j] == right) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        } 
        return null;
    } 

    public static void main(String[] args)  {
        int [] nus = new int[]{3, 2, 4};
        Solution solution = new Solution();
        int[] result = solution.twoSum(nus, 6);
        for (int i = 0; i < result.length; i++){
           System.out.println(result[i]);
        }
    }
}
