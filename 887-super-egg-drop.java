/**
 * 思路：动态规划
 */
class Solution {
    public int findNumberOfLIS(int[] nums) {
        Map<Integer, List<String>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){

            int num = nums[i];
            if (map.containsKey(num)){
                List<String> list = map.get(num);
                list.add(list.get(0));
            }else{
                
            }
        }
    }

    private List<Integer> find(int num, Map<Integer, List<String>> map) {
        int size = 0;
        for (Integer key : map.keySet()){
            if (key < num) {
                List list = map.get(key);
                size = Math.max(size, list.size());
            }
        }
        
    }

}
