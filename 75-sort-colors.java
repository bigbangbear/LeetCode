class Solution {
    public void sortColors(int[] nums) {
        int n0 = 0;
        int n1 = 0;
        int n2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                n0 ++;
            }
            if (nums[i] == 1) {
                n1 ++;
            }
            if (nums[i] == 2) {
                n2 ++;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (n0 > 0) {
                nums[j] = 0;
                n0--;
            }else 
            if (n1 > 0) {
                nums[j] = 1;
                n1--;
            }else
            if (n2 > 0) {
                nums[j] = 2;
                n2--;
            }
        }
        
    }

    public static void main(String[] args)  {

        int nums[] = new int[] {2,0,2,1,1,0};
        Solution solution = new Solution();
        solution.sortColors(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}

