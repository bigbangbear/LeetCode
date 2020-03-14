import java.lang.Math;
import java.util.HashMap;
import java.util.Map;

class Solution {

    private final Map<String, Integer> map = new HashMap<>();
    /**
     * 思路：从字符串尾部开始比较
     */
    public int minDistance(String word1, String word2) {
        int index1 = word1 == null ? 0 : word1.length();
        int index2 = word2 == null ? 0 : word2.length();

        return change(word1, word2, index1 - 1, index2 - 1);
    }

    private int change(String word1, String word2, int index1, int index2) {
        if (index1 < 0 && index2 < 0) {
            return 0;
        }
        if (index1 < 0 || index2 < 0) {
            return Math.max(index1, index2) + 1;
        }
        String key = "index1 = " + index1 + "index2 = " + index2;
        if (map.containsKey(key)){
            return map.get(key);
        }
        char c1 = word1.charAt(index1);
        char c2 = word2.charAt(index2);
        if (c1 == c2) {
            int min = change(word1, word2, index1 - 1, index2 - 1);
            setMin(key, min);
            return min;
        }else{
            // 插入 删除 替换
            int insert = change(word1, word2, index1, index2 - 1);
            int delete = change(word1, word2, index1 - 1, index2);
            int replace = change(word1, word2, index1 - 1, index2 -1);
            int min = Math.min(insert, Math.min(delete, replace)) + 1;
            setMin(key, min);
            return min;
        }
    }

    private void setMin(String key, int size) {
        if (map.get(key) != null) {
            int min = map.get(key);
            map.put(key, Math.min(min, size));
        }else {
            map.put(key, size);
        }
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = solution.minDistance("dinitrophenylhydrazine", "benzalphenylhydrazone");
        System.out.println("min distance: " + n);

    }
}
