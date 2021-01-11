class Solution {
    public int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int first = 1;
        int second = 1;
        int result = 0;
        for (int i=2; i<=n; i++) {
            result = (first + second) % 1000000007;
            first = second;
            second = result;
        }
        return result;
    }
}
