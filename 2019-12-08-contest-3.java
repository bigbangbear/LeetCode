class Solution {
    public int smallestDivisor(int[] nums, int threshold) {

        int result = 0;
        int minSum = Integer.MAX_VALUE;
        for (int i = 1; i <= threshold; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                sum += nums[j] / i;
                if (nums[j] % i > 0) {
                    sum++;
                }
            }
            if (sum < minSum) {
                sum = minSum;
                result = i;
            }
        }
        return result;

    }
}
