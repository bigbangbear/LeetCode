/**
 * 思路：整数转为未 2 进制数，计算 1 的数量
 * 测试：0 ，1 ，5, 最大的数
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
       int sum = 0; 
       while (n > 0){
           int tmp = n % 2;
           if (tmp == 1) {
               sum++;
           }
           n = n / 2;
       }
       return sum;
    }
}
