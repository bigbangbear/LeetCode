class ZeroEvenOdd { private int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    private AtomicInteger num = new AtomicInteger();
    private Semaphore zero = new Semaphore(1);
    private Semaphore odd = new Semaphore(0);
    private Semaphore even = new Semaphore(0);
    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i=0; i<n ; i++) {
            zero.acquire();
            printNumber.accept(0);
            num.incrementAndGet();
            if (num.get() % 2 == 1) {
                odd.release();
            }else {
                even.release();
            }

        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        int times = n / 2;

        for (int i=0; i<times; i++) {

            even.acquire();
            printNumber.accept(num.get());

            if (n != num.get()) {
                zero.release();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        int times = 0;
        if (n % 2 == 0) {
            times = n / 2;
        }else{
            times = n / 2 + 1;
        }
        for (int i=0; i < times ; i ++) {

            odd.acquire();
            printNumber.accept(num.get());

            zero.release();
        }
    }
}
