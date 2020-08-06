import java.util.Arrays;
class Solution {
    public int findDuplicate(int[] nums) {

        Arrays.sort(nums);

        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (pre == nums[i]) {
                return pre;
            }else {
                pre = nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        Solution solution = new Solution();
        int i = solution.findDuplicate1(nums);
        System.out.println("i" + i);
    }
}
