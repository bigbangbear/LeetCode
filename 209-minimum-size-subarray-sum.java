class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int minSize = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++){
                sum += nums[j];
                if (sum >= s) {
                    minSize = Math.min(minSize, j - i + 1);
                    break;
                }
            }
        }
        return minSize == Integer.MAX_VALUE? 0 : minSize;
    }
    public int minSubArrayLen1(int s, int[] nums) {
        if (s == 0 || nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0, right = 0, sum = 0, size = 0;
        int minSize = Integer.MAX_VALUE;
        for (int i = 0; i<nums.length; i++) {
            sum += nums[i];
            size ++;
            if (sum >= s) {
                minSize = Math.min(minSize, size);
                left = 0;
                right = i;
                break;
            }
        }
        while (true) {
            while (sum - nums[left] >= s) {
                sum -= nums[left];
                left++;
                size--;
                minSize = Math.min(minSize, size);
            }
            right++;
            size++;
            if (right >= nums.length) {
                break;
            }
            sum += nums[right];
        }

        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }

    public static void main(String[] args)  {
        Solution solution = new Solution();
        int [] nums = new int[]{12,28,83,4,25,26,25,2,25,25,25,12};
        int s = 213;
        int size = solution.minSubArrayLen1(s, nums);
        System.out.println(size);
    }
}

