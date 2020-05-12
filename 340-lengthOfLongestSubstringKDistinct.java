/**
 * 题目
 * Given a string, find the length of the longest substring T that contains at most k distinct characters.

 * Example 1:

 * Input: s = "eceba", k = 2
 * Output: 3
 * Explanation: T is "ece" which its length is 3.
 * Example 2:

 * Input: s = "aa", k = 1
 * Output: 2
 * Explanation: T is "aa" which its length is 2.
 */

import java.util.HashMap;
import java.util.Map;

class Solution {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.isEmpty() || k == 0) {
            return 0;
        }
        int left = 0, right = 0, size = 0;
        int maxSize = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i<s.length(); i++) {
            putChar(map, s.charAt(i));
            size++;
            if (map.size() == k) {
                right = i + 1;
                maxSize = Math.max(maxSize, k);
                break;
            }
        }

        while (right <= s.length() - 1) {
            System.out.println("left:" + left + " right:" + right + " size:" +size);
            while (map.size() > k) {
                takeChar(map, s.charAt(left));
                left++;
                size--;
            }
            putChar(map, s.charAt(right));
            right++;
            size++;

            if (map.size() == k) {
                maxSize = Math.max(size, maxSize);
            }
        }
        return maxSize == Integer.MIN_VALUE ? 0 : maxSize;

    }

    private void putChar(Map<Character, Integer> map, char c) {
        if (map.containsKey(c)) {
            map.put(c, map.get(c) + 1);
        }else {
            map.put(c, 1);
        }
    }

    private void takeChar(Map<Character, Integer> map, char c) {
        int size = map.get(c);
        if (size == 1) {
            map.remove(c);
        }else {
            map.put(c, size-1);
        }
    }

    public static void main(String[] args)  {
        String s = "dcebee";
        int size = 3;
        Solution solution = new Solution();
        int max = solution.lengthOfLongestSubstringKDistinct(s, size);
        System.out.println(max);
    }
}
