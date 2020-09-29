import java.util.Deque;
import java.util.ArrayDeque;

class Solution {

 public String simplifyPath(String path) {
        if (path == null) {
            return null;
        }

        Deque<String> deque = new ArrayDeque<>();
        String[] pathArray = path.split("/");
        for (int i = 0; i < pathArray.length; i++) {
            String context = pathArray[i];
            if (context.equals("") || context.equals(".")) {
                continue;
            }else if (context.equals("..")) {
                deque.poll();
            }else {
                deque.push(context);
            }
        }
        
        return getPath(deque);

    }

    private String getPath(Deque<String> deque) {
        StringBuilder sb = new StringBuilder();
        if (deque.isEmpty()) {
            sb.append("/");
        }
        while (!deque.isEmpty()) {
           System.out.println(deque.getLast());
           sb.append("/" + deque.removeLast());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.simplifyPath("/...");
        System.out.println(result);
    }
}
