class ZeroEvenOdd {
    private int n;
    private int current;
    private boolean isPrintZero = false;
    private boolean isPrintOdd = false;
    
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
        if (current == n) {
            return;
        }

        while(isPrintZero) {
            wait();
        }

        printNumber.accept(0);

        isPrintZero = true;
        notifyAll();
    }

    public synchronized void even(IntConsumer printNumber) throws InterruptedException {
        if (current == n) {
            return;
        } 
        while (isPrintZero == false || isPrintOdd == false) {
            wait();
        }
        printNumber.accept(current);
        isPrintZero = false;
        isPrintOdd = false;
        current++;
    }

    public synchronized void odd(IntConsumer printNumber) throws InterruptedException {
        if (current == n) {
            return;
        } 
        while (isPrintZero == false || isPrintOdd == true) {
            wait();
        }
        printNumber.accept(current);
        isPrintZero = false;
        isPrintOdd = true;
        current++;
        notifyAll();
       
    }
}
