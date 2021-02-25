class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null && popped == null) {
            return true;
        }
        if (pushed.length == 0 && popped.length == 0) {
            return true;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int i=0;
        int j=0;
        while(i < pushed.length) {
            if (pushed[i] == popped[j]) {
                i++;
                j++;
                continue;
            }else if (stack.size() > 0 && stack.peek().equals(popped[j])){
                stack.pop();
                j++;
            }  else{
                stack.push(pushed[i]);
                i++;
            }
        }
        for (; j<popped.length; j++) {
            if (stack.peek().equals(popped[j])) {
                stack.pop();
            }else {
                return false;
            }
        }
        return true;

    }
}

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
       
        Deque<Integer> stack = new ArrayDeque<>();
        int pop = 0;
        for (int num : pushed) {
            stack.push(num);
            while (stack.size() > 0 && stack.peek() == popped[pop]) {
                stack.pop();
                pop++;
            }
        }
        
        return stack.isEmpty();
    }
}
