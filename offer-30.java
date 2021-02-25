class MinStack {

    
    private Deque<Integer> stack = new ArrayDeque<Integer>();
    private Deque<Integer> min = new ArrayDeque<Integer>();

    /** initialize your data structure here. */
    public MinStack() {
    }

    public void push(int x) {
        if (min.size() == 0 || min.peek()  >= x) {
            min.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.size() == 0) {
            return;
        }
      if (stack.pop().equals(min.peek())) {
                min.pop();
            }
    }

    public int top() {
        return stack.peek();

    }

    public int min() {
        return min.peek();
    }


}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
