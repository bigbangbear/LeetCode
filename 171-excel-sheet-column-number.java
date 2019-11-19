/**
 * 简单：
class Solution {
    public int titleToNumber(String s) {
        int sum = 0;
        int base = 1;
        for (int i = 0; i < s.length(); i++){
            int num = getNum(s, i);
            sum = sum + num * base;
            base = base * 26;
        }
        return sum;
    }

    private int getNum(String s, int index){
        char c = s.charAt(s.length() - index - 1);
        return c - 'A' + 1;
    }
}
