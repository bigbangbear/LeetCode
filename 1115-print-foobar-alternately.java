class FooBar {
    private final int n;
    private final CyclicBarrier foo = new CyclicBarrier(2);
    private final CyclicBarrier bar = new CyclicBarrier(2);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            try {

                foo.await();
                System.out.println("foo");
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                foo.reset();

                bar.await();

            } catch (BrokenBarrierException e) {

            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            try {
                if (i == 0) {
                    foo.await();
                }
                bar.await();
                System.out.println("bar");
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                bar.reset();
                if (i < n - 1) {
                    foo.await();
                }


            } catch (BrokenBarrierException e) {

            }
        }
    }
}
