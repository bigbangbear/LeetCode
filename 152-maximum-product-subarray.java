class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int mul = nums[i];
            max = Math.max(mul, max);
            for (int j=i+1; j < nums.length; j++) {
                mul *= nums[j];
                if (mul >= max) {
                    max = mul;
                }
            }
        }
        return max;    
    }
}
