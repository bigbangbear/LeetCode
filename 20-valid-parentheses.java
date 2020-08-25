
import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public boolean isValid(String s) {

        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
               stack.addLast(c); 
            }else {
                if (stack.isEmpty()) {
                    return false;
                }else {
                    char last = stack.removeLast();
                    if (last == '(' && c == ')') {
                        continue;
                    }
                    if (last == '[' && c == ']') {
                        continue;
                    }
                    if (last == '{' && c == '}') {
                        continue;
                    }
                    return false;
                }
            }
        }
        return stack.isEmpty();
        
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean valid = solution.isValid("{}()");
        System.out.println(valid);

    }
}
