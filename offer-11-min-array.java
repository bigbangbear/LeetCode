/**
 * 思路，先判断是否有旋转。然后二分查找
 * 测试：[1] [] [1, 2, 3] [2, 1] [3 4 1 2] [2,2,2,0,1]
 */
class Solution {
    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("数组为空");
        }
        if (numbers[0] < numbers[numbers.length - 1]){
            return numbers[0];
        }
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++){
            if (min > numbers[i]) {
                return numbers[i];
            }
        }
        return min;
    }
}

class Solution {
    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("数组为空");
        }
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {

            int mid = (i + j) / 2;
            if (numbers[mid] > numbers[j]) {
                i = mid;
            }else if (numbers[mid] < numbers[j]){
                j = mid;
            }else if (numbers[mid] == numbers[j]){
                j = mid;
            }
        }
        return numbers[i];
    }
}
