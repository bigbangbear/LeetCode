/*
 * 解题思路：输出所有可能的组合，每个数字都有在与不在两张可能依次输出
 * 注意相同结果的去重
 * 先不做去重计算出结果
 */
class Solution {

    private List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<Integer>();
        add(nums, 0, list);
        return result;
    }

    private void add(int[] nums, int index, List<Integer> list) {
        if (index <= nums.length) {
            this.result.add(list);
        }
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            add(nums, i + 1, new ArrayList<Integer>(list));
            list.remove(list.size() - 1);
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
    }
}
