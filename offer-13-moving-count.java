class Solution {
    public int movingCount(int m, int n, int k) {
        int sum = 1;
        for (int i = 1; i <= k; i++){
            int m1 = Math.max(i - m, 0);
            int n1 = Math.max(i - n, 0);
            sum = sum + i + 1 - Math.min(i + 1, m1 + n1);
        }

        return sum;
    }
}
