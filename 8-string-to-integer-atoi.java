import java.lang.Character;
class Solution {
    public int myAtoi(String str) {
        int first = firstIsValid(str);
        if (first == -1) {
            return 0;
        }
        boolean isNegative = false;
        long result = 0;
        if (str.charAt(first) == '-') {
            isNegative = true;
        }else if (str.charAt(first) == '+') {

        }else{
            result = getNumber(str.charAt(first));
        }
        for (int i = first + 1; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isDigit(c)) {
                break;
            }
            long num = getNumber(c);
            if (isNegative && num > 0) {
                result =  num * -1;
                isNegative = false;
                continue;
            }
            if (result >= 0) {
                result = result * 10 + num;
            }else {
                result = result * 10 - num;
            }
            if (result > Integer.MAX_VALUE) {
                result = Integer.MAX_VALUE;
            }else if (result < Integer.MIN_VALUE) {
                result = Integer.MIN_VALUE;
            }
        }
        return (int)result;
    }

    private long getNumber(char c) {
        return (long) (c - '0');
    }

    private int firstIsValid(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (Character.isDigit(c)) {
                return i;
            }else if (c == '-' || c == '+') {
                return i;
            }
            return -1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.myAtoi("  +1");
        System.out.println(result);
    }
}
