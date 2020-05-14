import java.util.Map;
import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = Integer.MIN_VALUE;
        int left = 0;
        int right = 0;
        Map<Character, Boolean> map = new HashMap<>();
        while(right < s.length()) {
            if (map.containsKey(s.charAt(right))) {
                while (map.containsKey(s.charAt(right))) {
                    map.remove(s.charAt(left));
                    left++;
                }
            }
            map.put(s.charAt(right), true);
            max = Math.max(map.size(), max);
            right++;
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }

    public static void main(String[] args)  {
        String s = "";
        Solution solution = new Solution();
        int max = solution.lengthOfLongestSubstring(s);
        System.out.println(max);
    }
}
