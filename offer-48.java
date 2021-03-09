class Solution {
    
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int right = 0;
        int max = Integer.MIN_VALUE;
        for (int i=0; i<s.length(); i++) {
            Character c = s.charAt(i);
            if (set.contains(c)) {
                set.clear();
                set.add(c);
                right = i;
                while (right-1 >= 0 && !set.contains(s.charAt(right-1))) {
                    set.add(s.charAt(right-1));
                    right--;
                }
            }else {
                set.add(c);
                max = Integer.max(i + 1 - right, max);
            }
        }
        return max;
    }
}
