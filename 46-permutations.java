import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.ArrayDeque;
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Deque<Integer> path = new ArrayDeque<>(nums.length);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        help(result, path, used, nums);
        return result;
    }

    private void help(List<List<Integer>> result, Deque<Integer> path, boolean[] used, int[] nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i <nums.length; i++) {
            if (used[i] == true) {
                continue;
            }
            used[i] = true;
            path.addLast(nums[i]);
            help(result, path, used, nums);
            used[i] = false;
            path.removeLast();
        }
    }

    

    public static void main(String[] args) {
        int tmp[] = {1,2,3};
        Solution solution = new Solution();
        List<List<Integer>> result  =solution.permute(tmp);
        for (int i = 0; i <result.size(); i++) {
            for (int j = 0; j <result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + "  ");
            }
            System.out.println("");
        }

    }
}
