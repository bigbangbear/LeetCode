import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 >= nums.length) {
                continue;
            }
            if (nums[i] == nums[i + 1]) {
                result.add(nums[i]);
                i++;
            }       
        }
        return result;
    }

    public static void main(String[] args) {
        int nums[] = {4,3,2,7,8,2,3,1};
        Solution solution = new Solution();
        List<Integer> result = solution.findDuplicates1(nums);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }

    }
}
