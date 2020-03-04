/**
 * 思路：递归
 * 测试：2 、4、10
 */
class Solution {
    private int max = 0;
    public int cuttingRope(int n) {
        for (int i = 1; i<n; i++){
            getMax(n -i, i);
        }
        return max;
    }

    private void getMax(int n, int mutiple) {
        if (n <= 1) {
            max = Math.max(max, mutiple);
            return;
        }
        for (int i = 1; i <= n; i++) {
            getMax(n-i, mutiple * i);
        }
    }
}
