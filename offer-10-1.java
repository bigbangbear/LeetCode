class Solution {
    public int fib(int n) {
        int first = 0;
        int second = 1;
        if (n == 0) {
            return first;
        }else if (n == 1) {
            return second;
        }
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = (first + second) % 1000000007;
            first = second;
            second = result;
        }
        return result;
    }
}
