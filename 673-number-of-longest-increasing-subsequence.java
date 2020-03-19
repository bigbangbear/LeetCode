class Solution {
    public int findNumberOfLIS(int[] nums) {
        List<Integer> len = new ArrayList<>();
        List<Integer> size = new ArrayList<>();
    
        for (int i = 0; i < nums.length; i++) {
            List<Integer> max = getMaxLen(nums, len, nums[i]);
            if (max.isEmpty()) {
                len.add(1);
                size.add(1);
            } else {
                len.add(1 + len.get(max.get(0)));
                int sum = 0;
                for(Integer index: max) {
                    sum += size.get(index);
                }
                size.add(sum);
            }
        }
        List<Integer> max = getMaxLen(nums, len, Integer.MAX_VALUE);
        int sum = 0;
        for (int i =0; i<max.size(); i++) {
            sum += size.get(max.get(i));
        }
        return sum;
    }

    private List<Integer> getMaxLen(int[] nums, List<Integer> len, int num) {
        List<Integer> result = new ArrayList<>();
        int maxLen = 0;
        for (int i = 0; i < len.size(); i++) {
            if (num > nums[i]) {
                if (len.get(i) > maxLen) {
                    result.clear();
                    result.add(i);
                    maxLen = len.get(i);
                } else if (len.get(i) == maxLen) {
                    result.add(i);
                }
            }
        }
        return result;
    }
}
