class Solution {
    public boolean isMatch(String s, String p) {
        if (p.length() == 0){
            return s.length() == 0;
        }
        char sChar = s.charAt(0);
        char pChar = p.charAt(0);
        if (sChar == pChar) {
            return isMatch(s.substring(1), p.substring(1));
        }else{
            if (pChar == '.') {
                return isMatch(s.substring(1), p.substring(1)) || isMatch(s.substring(0), p.substring(1));
            }else if (pChar == '*') {
                return isMatch()

            }else {
                return false;
            }
        }
    }
}
