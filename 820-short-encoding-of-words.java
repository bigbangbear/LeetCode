import java.lang.StringBuilder;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int minimumLengthEncoding(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        sort(words);
        StringBuilder sb = new StringBuilder();
        int[] index = new int[words.length];
        for (int i = 0; i < words.length; i++){
            String word = words[i];
            int wordLength = word.length();
            boolean contains = false;
            for (int j = 0; j < i; j++) {
                if (wordLength <= words[j].length()){
                    int length = words[j].length() - wordLength;
                    String compare = words[j].substring(length);
                    if (compare.equals(word)){
                        contains = true;
                        index[i] = length;
                        break;
                    }
                }
            }
            if (!contains) {
                int length = sb.length();
                sb.append(word);
                sb.append('#');
                index[i] = length;
            }
        }
        return sb.length();
    }

    private void sort(String[] words) {
        Arrays.sort(words, new Comparator<String>(){
            public int compare(String a, String b) {
                if (a.length() == b.length()) {
                    return 0; 
                }
                if (a.length() < b.length()){
                    return 1;
                }else{
                    return -1;
                }
            }
        });

    }
}

class Main {
    public static void main(String[] args){

        String[] words = new String[]{"time", "time", "time", "time" };
        Solution solution = new Solution();
        System.out.println(solution.minimumLengthEncoding(words));
    }
}
