import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        int length = allLength(words);
        Map<String, Boolean> map = convertMap(words);
        int wordLength = words[0].length();
        for (int i = 0; i + length < s.length(); i++) {
            String sub = s.substring(i, i + length + 1);
            List<String> list = convertString(sub, wordLength);
            int j = 0;
            for (; j < list.size(); j++) {
                if (map.get(list.get(j)) == null) {
                    break;
                }
            }
            if (j == list.size()) {
                result.add(i);
            }
        }
        return result;
    }

    private List<String> convertString(String word, int length) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < word.length(); i = i + length) {
            list.add(word.substring(i, i + length));
        }
        return list;
    }

    private Map<String, Boolean> convertMap(String[] words) {
        Map<String, Boolean> map = new HashMap<>();
        for (int i = 0; i < words.length; i++){
            map.put(words[i], true);
        }
        return map;
    }
    private int allLength(String [] words) {
        int length = 0;
        for (String word : words) {
            length += word.length();
        }
        return length;
    }


}

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        int length = allLength(words);
        Map<String, Integer> map = convertMap(words);
        int wordLength = words[0].length();
        for (int i = 0; i + length <= s.length(); i++) {
            Map<String, Integer> convert = convertString(s,i, wordLength, words.length);
            if (map.equals(convert)) {
                result.add(i);
            }
        }
        return result;
    }

    private Map<String, Integer> convertString(String word,int index, int length, int time) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i< time; i++) {
            String key = word.substring(index + i * length, index + i * length + length);
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            }else {
                map.put(key, 1);
            }
        }
        return map;
    }

    private Map<String, Integer> convertMap(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.get(words[i]) != null) {
                map.put(words[i], 1 + map.get(words[i]));
            }else {
                map.put(words[i], 1);
            }
        }
        return map;
    }

    private int allLength(String[] words) {
        int length = 0;
        for (String word : words) {
            length += word.length();
        }
        return length;
    }


}

