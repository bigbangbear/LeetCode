class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 9, 1, 2};
        Solution solution = new Solution();
        boolean succes = solution.stoneGame(nums);
        System.out.println("succes" + succes);
    }
}
class Solution {

    class Meta {
        int first;
        int second;

        public String toString() {
            return "f=" + first + ", s=" + second;
        }
    }
    public boolean stoneGame(int[] piles) {
        if (piles == null || piles.length == 0) {
            return false;
        }
        Meta[][] dp = new Meta[piles.length][piles.length];
        for(int i=piles.length; i>0; i--) {
            int x = 0;
            int y = piles.length - i;
            for(int j=0; j<i; j++) {
                if (x == y) {
                    Meta meta = new Meta();
                    meta.first = piles[x];
                    meta.second = 0;
                    dp[x][y] = meta;
                }else {
                    Meta meta = new Meta();
                    int left =  piles[x] + dp[x+1][y].second;
                    int right = piles[y] + dp[x][y-1].second;
                    meta.first = Math.max(left, right);
                    if (left < right) {
                        meta.second = dp[x][y-1].first;
                    }else{
                        meta.second = dp[x+1][y].first;
                    }
                    dp[x][y] = meta;
                }
                x++;
                y++;
            }
        }
        return dp[0][piles.length - 1].first > dp[0][piles.length- 1].second;
    }
}
