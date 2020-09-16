import java.util.Map;
import java.util.HashMap;
class Solution {
    public String convert(String s, int numRows) {
        int step = 2*numRows  - 2;
        step = step > 0 ? step : 1;
        Map<Integer, StringBuilder> map = new HashMap<>();

        for (int i = 0; i<numRows; i++) {
            map.put(i, new StringBuilder());
        }

        for (int i = 0; i < s.length(); i++) {
            int line = getLineNumber(i, numRows, step);
            map.get(line).append(s.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <numRows; i++) {
            sb.append(map.get(i).toString());
        }
        return sb.toString();
    }

    private int getLineNumber(int num,int numRows,int step) {
        num = num % step;
        if (num < numRows) {
        }else {
            num = numRows - (num - numRows) - 1 - 1;
        }
        return num;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.convert("P", 1);
        System.out.println(result);
    }
}
