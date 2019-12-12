/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
class MinStack {

    private List<Integer> stack;

    /** initialize your data structure here. */
    public MinStack() {
        this.stack = new ArrayList<Integer>();
    }

    public void push(int x) {
        this.stack.add(x);

    }

    public void pop() {
        this.stack.remove(this.stack.size() - 1);

    }

    public int top() {
        return this.stack.get(this.stack.size() - 1);

    }

    public int getMin() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < this.stack.size(); i++) {
            min = Math.min(min, this.stack.get(i));
        }
        return min;

    }

}


