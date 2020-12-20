import java.util.PriorityQueue;
import java.lang.Math;
import java.util.Comparator;

class WordDictionary {

    private PriorityQueue<String> words = new PriorityQueue<String>(new Comparator<String>() {
        @Override
        public int compare(String a, String b) {
            int size = Math.min(a.length(), b.length());
            for (int i = 0; i < size; i++) {
                char cA = a.charAt(i);
                char cB = b.charAt(i);
                if (cA == cB) {
                    return 0;
                }
                if (cA > cB) {
                    return -1;
                }else {
                    return 1;
                }
            }
return :q
        }
    });
    private String[] searchWord = null;
    /** Initialize your data structure here. */
    public WordDictionary() {

    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {

    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {

    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
