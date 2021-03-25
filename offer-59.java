//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。 
//
// 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/ 
// Related Topics 队列 Sliding Window 
// 👍 225 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        List<Integer> list = new ArrayList<>(k);
        int max = Integer.MIN_VALUE;
        for (int i=0; i<k; i++) {
            max = Math.max(max, nums[i]);
            list.add(nums[i]);
        }
        result[0] = max;
        int index = 1;
        for (int i=k; i<nums.length; i++) {
            int num = nums[i];
            if (num >= max) {
                max = num;
                list.add(max);
                list.remove(0);
            }else {
                int first = list.get(0);
                if (first < max) {
                    list.remove(0);
                    list.add(num);
                }else {
                    list.remove(0);
                    list.add(num);
                    max = findMax(list);
                }
            }
            result[index] = max;
            index++;
        }

        return  result;
    }

    private int findMax(List<Integer> list) {
        int max = list.get(0);
        for (Integer num: list) {
            max = Math.max(num, max);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

