import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
       List<List<Integer>> result = new ArrayList<List<Integer>>(); 
       List<Integer> list = new ArrayList<Integer>();
       help(result, nums, 0, list);
       return result;
    }

    private void help(List<List<Integer>> result, int[] nums, int index, List<Integer> list) {
        if (index == nums.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        help(result, nums, index + 1, new ArrayList<Integer>(list));
        list.add(nums[index]);
        help(result, nums, index + 1, new ArrayList<Integer>(list));
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3};
        Solution solution = new Solution();
        List<List<Integer>> result  = solution.subsets(nums);
        for (int i = 0; i < result.size(); i++) {
            for (int j= 0; j < result.get(i).size(); j++) {
                System.out.print("  " + result.get(i).get(j));
            }
            System.out.println("");
        }
    }
}
