/**
 * 题目：求解出所有组合为目标树的元组集合
 * 思路：如何回溯遍历所有的元素
 */
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        help(candidates, target, result, list, 0, 0);
        return result;
    }

    private void help(int[] candidates, int target, List<List<Integer>> result, List<Integer> list, int index, int sum) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(list);
            return;
        }
        if (index >= candidates.length) {
            return;
        }
        int nextIndex = index;
        while (1 + nextIndex < candidates.length && candidates[nextIndex+1] == candidates[index]) {
            nextIndex++;
        }
        // 不存在
        help(candidates, target, result, new ArrayList<Integer>(list), nextIndex + 1, sum);
        // 存在
        for (int i= index; i<=nextIndex; i++) {
            list.add(candidates[i]);
            sum += candidates[i];
            help(candidates, target, result, new ArrayList<Integer>(list), nextIndex + 1, sum);
        }
    }}
