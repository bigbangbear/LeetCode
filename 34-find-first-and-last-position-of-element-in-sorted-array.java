/**
 * 题目：在 log(n) 的时间复杂度内返回目标值的区间指针
 * 思路：二分查找
 * 注意：元素只有一个的情况
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int num = nums[mid];
            if (num == target) {
                left = mid;
                right = mid;
                while (left - 1 >= 0 && nums[left - 1] == target) {
                    left--;
                }
                while (right + 1 < nums.length && nums[right + 1] == target) {
                    right++;
                }
                return new int[] { left, right };
            } else if (num > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return new int[] { -1, -1 };
    }
}
