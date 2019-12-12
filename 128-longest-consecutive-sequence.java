/**
 * 题目：返回数组中连续的数字列表的长度
 * 思路：用 Map 存储当前数组的最大联系个数
 * 测试：[100,4,200,1,3,2]
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxLength = 1;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        // 遍历数组，把当前数字最大连续长度存在 Map 中
        for (int i = 0; nums != null && i < nums.length; i++) {
            int num = nums[i];
            if (map.get(num - 1) != null) {
                // 当前数字的减一存在，则当前数字的最大长度为前一数字加一
                map.put(num, map.get(num - 1) + 1);
                maxLength = Math.max(maxLength, map.get(num));
            } else {
                // 前一数字不存在，当前数字长度为一
                map.put(num, 1);
            }
            int behind = 1;
            // 假如当前数组后面还有数字，更新对应数字的长度
            while (map.get(num + behind) != null) {
                map.put(num + behind, map.get(num) + behind);
                maxLength = Math.max(maxLength, map.get(num + behind));
                behind++;
            }

        }
        return maxLength;
    }
}
