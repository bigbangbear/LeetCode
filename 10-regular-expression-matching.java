import java.util.HashMap;
import java.util.Map;
/**
 * 正则匹配，还是大佬牛逼呀
 */
class Solution {
    Map<String, Boolean> dp = new HashMap<>();
    public boolean isMatch(String s, String p) {
        String key = getKey(s, p);
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        if (p.isEmpty()) {
            dp.put(key, s.isEmpty());
            return s.isEmpty();
        }
        boolean firstMatch = false;
        if (!s.isEmpty()){
            firstMatch = (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        }
        if (p.length() >= 2 && p.charAt(1) == '*') {
            boolean match = isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
            dp.put(key, match);
            return match;
        }
        boolean match = firstMatch && isMatch(s.substring(1), p.substring(1));
        dp.put(key, match);
        return match;
    }

    private String getKey(String s, String p) {
        return "s=" + s + "p=" + p;
    }
}

class Main {

    public static void main(String[] args) {
        String s = "aab";
        String p = ".*";
        Solution solution = new Solution();
        boolean match = solution.isMatch(s, p);
        System.out.println(match);
    }
}
