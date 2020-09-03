class Solution {
    public int findKthLargest(int[] nums, int k) {
        int loop = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] > nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
            if (i == k-1) {
                return nums[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        Solution solution = new Solution();
        int num = solution.findKthLargest(nums, 4);
        System.out.println(num);
    }
}
