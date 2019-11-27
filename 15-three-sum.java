/**
 * 思路：暴力枚举法，失败，时间超时
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Map<String, Integer> map = new HashMap<String, Integer>();

        int pre = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length && nums[i] > pre && nums[i] <= 0; i++){
            for (int j=i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] > 0 ) {
                    break;
                }
                for(int k=j+1; k < nums.length; k++){
                    if (nums[i] + nums[j] + nums[k] == 0){
                        String key = "i" + nums[i] + "j" + nums[j] + "k" + nums[k];
                        if (!map.containsKey(key)){
                            map.put(key, 1);    
                            result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        }
                    }else if (nums[i] + nums[j] + nums[k] > 0){
                        break;
                    }
                }
            }
            pre = nums[i];
        }
        return result;
    }
}
/**
 * 解题：增加双指针提高速度
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 排序
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i<nums.length && nums[i] <= 0; i++){
            // 如果与前一个数字相同跳过，避免重复
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            // 双指针提高检索速度
            int left = i + 1;
            int right = nums.length - 1;
            while(left<right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0){
                    result.add(Arrays.asList(nums[i] , nums[left] , nums[right]));
                    while(left + 1 < nums.length && nums[left + 1] == nums[left]){
                        left++;
                    }
                    while(right - 1 >= 0 && nums[right - 1] == nums[right]) {
                        right--;
                    }
                    left++;
                    right--;
                }else if (sum > 0) {
                    right--;
                }else {
                    left++;
                }
            }
        }
        return result;


    }
}
