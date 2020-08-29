class Solution {
    public int rangeBitwiseAnd(int m, int n) {

        int move = 0;
        while ( m != n ) {
            move ++;
            m >>= 1;
            n >>= 1;
        }
        if (m == 0) {
            return 0;
        }else {
            return m << move;
        }
    }
}
