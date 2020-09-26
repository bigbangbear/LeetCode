class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        help(candidates, target, 0, 0, result, list);
        return result;
    }

    public void help(int[] candidates, int target, int index, int sum, List<List<Integer>> result, List<Integer> list) {
        if (target == sum) {
            result.add(list);
            return;
        }
        if (target < sum) {
            return;
        }
        if (index >= candidates.length) {
            return;
        }
       
        help(candidates, target, index + 1, sum, result, new ArrayList<>(list));
        while(sum <= target) {
            sum += candidates[index];
            list.add(candidates[index]);
            help(candidates, target, index + 1, sum, result, new ArrayList<>(list));
        }
    }
}
