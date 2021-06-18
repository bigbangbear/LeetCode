class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 0;
        for (int i=lowLimit; i<= highLimit; i++) {
            int num = getNum(i);
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            }else {
                map.put(num, 1);
            }
            max = Math.max(max, map.get(num));
        }
        return max;
    }

    private int getNum(int num) {
        int sum = 0;
        while ( num > 0) {
            int t = num % 10;
            num /= 10;
            sum += t;
        }
        return sum;
    }
    
}
