/**
 * 题目：求解出所有组合为目标树的元组集合
 * 思路：如何回溯遍历所有的元素
 */
class Solution {
    List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<Integer>();
        combine(candidates, 0, target, path);
        return result;
    }

    private void combine(int[] candidates, int current, int target, List<Integer> path) {
        if (target == 0) {
            result.add(new ArrayList(path));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = current; i < candidates.length; i++) {
            path.add(candidates[i]);
            // 传递的是当前指针
            combine(candidates, i + 1, target - candidates[i], path);
            path.remove(path.size() - 1);
            while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
                i++;
            }
        }
    }
}
