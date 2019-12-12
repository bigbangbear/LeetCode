/**
 * [67] Add Binary
 *
 *https://leetcode.com/problems/add-binary/description/
 */
class Solution {
    public String addBinary(String a, String b) {

        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }
        int length = Math.max(a.length(), b.length());
        StringBuilder sb = new StringBuilder();
        int temp = 0;
        for (int i = 0; i < length; i++) {

            int numOfA = getNumberOf(a, i);
            int numOfB = getNumberOf(b, i);
            int sum = numOfA + numOfB + temp;

            sb.append(sum % 2);
            temp = sum / 2;
        }
        if (temp == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();

    }

    public int getNumberOf(String string, int index) {
        if (index >= string.length()) {
            return 0;
        }
        return string.charAt(string.length() - 1 - index) - '0';
    }

}
