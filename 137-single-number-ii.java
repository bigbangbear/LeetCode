/**
 * 找出数组中只出现一次的元素
 * 要求：线性时间
 */
class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (numMap.containsKey(num)) {
                int size = numMap.get(num);
                numMap.put(num, size + 1);
            } else {
                numMap.put(num, 1);
            }
        }
        for (Integer key : numMap.keySet()) {
            if (numMap.get(key) == 1) {
                return key;
            }
        }
        return 0;
    }
}
