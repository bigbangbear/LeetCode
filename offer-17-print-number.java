/**
 * 思路：10 ^ n - 1
 */
class Solution {
    public int[] printNumbers(int n) {
        int size = 1;
        for (int i = 0; i < n; i++){
            size *= 10;
        }
        size--;
        int[] result = new int[size];
        for (int i = 0; i < size; i++){
            result[i] = i + 1;
        }
        return result;
    }
}

