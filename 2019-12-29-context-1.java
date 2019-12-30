class Solution {
    public int[] sumZero(int n) {
        int[] result = new int[n]; 
        for (int i = 0; i < n /2; i++){
            result[i] = n - i;
            result[n-1-i] = - (n - i);
        }
        return result;;
    }
}
