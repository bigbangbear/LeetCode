import java.util.HashMap;
import java.util.Map;

class Solution {
    public int totalFruit(int[] tree) {
        int left = 0;
        int max = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int right = 0; right < tree.length; right++) {
            put(map, tree[right]);
            if (map.size() > 2 ) {
                while(map.size() > 2) {
                    take(map, tree[left]);
                    left++;
                }
            }
            if (map.size() <= 2 ) {
                max = Math.max(max, right - left + 1); 
            }
        }
        return max;
    }

    private void put(Map<Integer, Integer> map, int type) {
        if (map.containsKey(type)) {
            map.put(type, map.get(type) + 1);
        }else {
            map.put(type, 1);
        }
    }

    private void take(Map<Integer, Integer> map, int type) {
        if (map.get(type) > 1) {
            map.put(type, map.get(type) - 1);
        }else {
            map.remove(type);
        }
    }

    public static void main(String[] args)  {
        int[] tree = new int[]{3,3,3,1,2,1,1,2,3,3,4};
        Solution solution = new Solution();
        int max = solution.totalFruit(tree);
        System.out.println(max);
    }


}
