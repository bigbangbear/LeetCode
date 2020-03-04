/**
 * 思路：遍历字符，添加到新的字符串上，如果是空格进行替换
 */
class Solution {
    public String replaceSpace(String s) {
        if (s == null) {
            return null;
        } 
        if (s.length() == 0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == ' '){
                sb.append("%20");
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
