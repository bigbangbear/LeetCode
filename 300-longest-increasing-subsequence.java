/**
 * 思路：最长递增子序列的长度
 * [10,9,2,5,3,7,101,18]
 * d[i] = x
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        int lastMax = 0;
        HashMap<Integer, Integer> dp = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp.get(j) + 1);
                }
            }
            dp.put(i, max);
            lastMax = Math.max(lastMax, max);
        }
        return lastMax;
    }
}
