/*
 * 解题思路：输出所有可能的组合，每个数字都有在与不在两张可能依次输出
 * 注意相同结果的去重
 * 先不做去重计算出结果
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        help(result, list, nums, 0);
        return result;
    }

    private void help(List<List<Integer>> result, List<Integer> list, int[] nums, int index) {
        if (index <= nums.length) {
            result.add(new ArrayList<>(list));
        }
        System.out.println("index=" + index);
        for (int i = index; i < nums.length; i++) {
            System.out.println("i = " + i + "  ");
            list.add(nums[i]);
            help(result, new ArrayList<>(list), nums, i + 1);
            list.remove(list.size() - 1);
            while (i < nums.length - 1 && nums[i] == nums[i+1]) {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 2};
        Solution solution = new Solution();
        List<List<Integer>> result  = solution.subsetsWithDup(nums);
        for (int i = 0; i < result.size(); i++) {
            for (int j= 0; j < result.get(i).size(); j++) {
                System.out.print("  " + result.get(i).get(j));
            }
            System.out.println("");
        }
    }

}
