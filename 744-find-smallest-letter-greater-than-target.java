import java.lang.Math;
class Solution {
    public char nextGreatestLetter1(char[] letters, char target) {

        int size = 26;
        int min = Integer.MAX_VALUE;
        char minChar = 'a';
        for (int i = 0; i < letters.length; i++) {
            int length = letters[i] - target;
            if(length == 0) {
                continue;
            }
            if (length < 0) {
                length = size + length;
            }
            if (length < min) {
                min = length;
                minChar = letters[i];
            }
        }
        return minChar;

    }


}
