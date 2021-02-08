/**
 * Java 中数字的表示：有符号数字，最高位用来表示正负，1 (负数) 2(正数)
 * >> 有符号位移 >>> 无符号位移
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int num = 0;
        while (n != 0) {
            if ((n & 1) != 0) {
                num++;
            }
            n = (n >>> 1);
        }
        return num;
    }
}
