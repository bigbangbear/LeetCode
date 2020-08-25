import java.util.List;
import java.util.ArrayList;
import java.lang.Character;

class Solution {
    public List<String> letterCasePermutation(String S) {
       List<String> result = new ArrayList<String>(); 
       help(result, "", S);
       return result;
    }

    public void help(List<String> result, String path, String S) {
        if (path.length() == S.length()) {
            result.add(path);
            return;
        }
        int index = path.length();
        char current = S.charAt(index);
        if (Character.isDigit(current)) {
            String newPath = path + current;
            help(result, newPath, S);
        }else {
            help(result, path + Character.toLowerCase(current), S);
            help(result, path + Character.toUpperCase(current), S);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> paths = solution.letterCasePermutation("a1b2");
        for (String path : paths) {
            System.out.println(path);
        }
    }
}
