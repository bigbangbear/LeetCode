class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; i++){
            int left = nums[i];
            int right = i;
            for (int j = i; j < len; j++) {
                if (nums[j] == left) {
                    right = j;
                }
                if (nums[j] != left) {
                    break;
                }
            }
            if (i != right) {
                len -= (right - i);
                for (int k = i+1; k < len; k++) {
                    nums[k] = nums[k + right - i];
                }
            }
        }

        return len;
    }

    public int removeDuplicates1(int[] nums) {

        int i = 0;
        int len = 1;
        for (int j=1; j<nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                len++;
                nums[i] = nums[j];
                system.out.println("i =" + i + "num =" + nums[i]);
            }
        }
        return len;

    }

    public static void main(String[] args)  {
        int [] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        Solution solution = new Solution();
        int len = solution.removeDuplicates1(nums);
        System.out.println("len" + len);
    }
}
