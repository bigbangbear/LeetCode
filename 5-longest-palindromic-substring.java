import java.lang.Math;
class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        for (int i=0; i<s.length(); i++) {
            result = help(s, result, i, i);
            result = help(s, result, i, i+1);
        }
        return result;
    }

    private String help(String s,String result, int i, int j) {
        if (i < 0 || j >= s.length() || s.charAt(i) != s.charAt(j)) {
            return result;
        }
        while (i-1 >=0 && j + 1 < s.length()) {
            if (s.charAt(i-1) == s.charAt(j+1)) {
                i--;
                j++;
            } else{
                break;
            }
        }
        
        if (j - i + 1 > result.length()) {
            System.out.println("i = " + i + "j" + j);
            return s.substring(i, j+1);
        }else {
            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.longestPalindrome("cbbd");
        System.out.println(result);
    }
}
