class Solution {
    public String replaceSpace(String s) {

        String blank = "%20";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                sb.append(blank);
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
