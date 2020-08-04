import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
class Solution {
    public int missingNumber(int[] nums) {
        Set<Integer> map = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (!map.contains(i)) {
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] nums = {0};
        Solution solution = new Solution();
        int num = solution.missingNumber(nums);
        System.out.println("num" + num);
    } 
}
