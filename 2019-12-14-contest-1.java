/**
 * 题目：element-appearing-more-than-25-in-sorted-array
 * 思路：判断当前数字是否与当前数字后四分之一长度位置的数字相等
 */
class Solution {
    public int findSpecialInteger(int[] arr) {
        int length = arr.length;
        int min = length / 4;
        for (int i = 0; i < length && i + min < length; i++){
            if (arr[i] == arr[i + min]) {
                return arr[i];
            }
        }
        return 0;
    }
}
