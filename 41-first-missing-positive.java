class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int min = 1;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] <= 0 || nums[i] < min) {
                continue;
            }else {
                if (nums[i] != min) {
                    return min;
                }else {
                    min++;
                }
            }
        }
        return min;
    }
}
