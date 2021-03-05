class Solution {
     int result = 0;

    public int translateNum(int num) {
        help(String.valueOf(num), 0);
        return result;
    }

    private void help(String num, int index) {
        if (index==num.length()) {
            result++;
            return;
        }else if (index > num.length()) {
            return;
        }
        int number = getNum(num, index);
        if (number == 0 || number > 2) {
            help(num, index+1);
            return;
        }else if (number == 1) {
            help(num, index + 1);
            help(num, index+2);
        }else if (number == 2) {
            help(num, index+1);
            if (index + 1 < num.length() && getNum(num, index + 1) <= 5) {
                help(num, index + 2);
            }
        }
    }

    private int getNum(String num, int index) {
        return num.charAt(index) - '0';
    }
}
