/**
 * 思路：锁
 * 测试：
 */
class FooBar {
    private int n;
    private boolean isPrintFoo = false;

    public FooBar(int n) {
        this.n = n;
    }

    public synchronized void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            while (isPrintFoo) {
                wait();
            } 
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
            isPrintFoo = true;
            notifyAll();
        }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
            while(!isPrintFoo) {
                wait();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
            isPrintFoo = false;
            notifyAll();
        }
    }
}
