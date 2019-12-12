/**
 * 爬楼梯，每次可以爬一级或者两级
 * 动态规划解法
 * 最小 f(1) = 1; f(2) = 2
 * f(3) = f(2) + f(1)
 * f(n) = f(n -1) + f(n -2)
 */
class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int next1 = 1;
        int next2 = 2;
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = next1 + next2;
            next1 = next2;
            next2 = result;
        }
        return result;

    }
}
