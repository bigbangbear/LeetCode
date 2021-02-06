class Solution {
    public int cuttingRope(int n) {

        if (n <= 0) {
            return 0;
        }
        int max = 1;
        for (int i = 2; i <= n; i++) {
            int num = n / i;
            int remain = n % i;
            int tmp = 1;
            for (int j = 0; j < i; j++) {
                if (remain > 0) {
                    tmp *= (num +  1);
                    remain--;
                }else {
                    tmp *= num;
                }
            }
            max = Math.max(max, tmp);
        }

        return max;

    }
}
