class CQueue {

    private ArrayDeque<Integer> delete = new ArrayDeque<Integer>();
    private ArrayDeque<Integer> add = new ArrayDeque<Integer>();
    public CQueue() {

    }
    
    public void appendTail(int value) {
        add.push(value);
    }
    
    public int deleteHead() {
        if (add.size() == 0) {
            return -1;
        }
        while(add.size() > 0) {
            delete.push(add.pop());
        }
        int result = delete.pop();
        while(delete.size() > 0)  {
            add.push(delete.pop());
        }
        return result;

    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 *//
