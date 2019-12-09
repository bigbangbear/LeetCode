/**
 * 简单：一个数字，获取每位上的数字进行求和与求积运算，计算出差
 */
class Solution {
    public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;
        while (n > 0) {
            int num = n % 10;
            sum += num;
            product = product * num;
            n = n / 10;
        }
        return product - sum;
    }
}
