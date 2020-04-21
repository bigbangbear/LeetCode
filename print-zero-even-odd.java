class ZeroEvenOdd {

    private int n;
    private int current = 1;
    private boolean isPrintZero = true;
    
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (!isPrintZero) {
            wait();
        }  
        printNumber.accept(0);
        isPrintZero = false;
        notifyAll();
    }

    public void even(IntConsumer printNumber) throws InterruptedException {

        boolean isEven = (current % 2 == 0);
        while(!isPrintZero && !isEven) {
            wait();
        } 
        isPrintZero = true;
        current++;
        notifyAll();
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
 
        boolean isOdd = (current % 2 == 0);
        while(!isPrintZero && !isOdd) {
            wait();
        } 
        isPrintZero = true;
        current++;
        notifyAll();
       
    }
}
