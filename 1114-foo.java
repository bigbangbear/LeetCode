class Foo {

    private boolean firstRun = true;
    private boolean thirdRun = true;
    
    public Foo() {
    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstRun = false;
        notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        while(firstRun) {
            wait();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        thirdRun = false;
        notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        while(thirdRun) {
            wait();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        notifyAll();
    }
}
