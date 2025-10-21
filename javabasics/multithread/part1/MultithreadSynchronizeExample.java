package multithread.part1;

/*
    Q1.Thread-safe Counter using synchronized

    Create a counter class where multiple threads increment a shared counter safely using synchronized.
*/
public class MultithreadSynchronizeExample {

    public static void main(String[] args) {
        CounterSynchronize count = new CounterSynchronize();
        Runnable increment = new Runnable() {

            @Override
            public void run() {
                for (int i = 1; i <= 1000; i++) {
//                System.out.println("run");
                    count.increment();
                }
            }
        };
        Thread t1 = new Thread(increment);
        Thread t2 = new Thread(increment);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(count.getCounter());

    }

    public static class CounterSynchronize {
        int counte = 0;

        public synchronized void increment() {
            //        System.out.println("run");
            this.counte++;
        }

        public int getCounter() {
            //        System.out.println(this.counte);
            return this.counte;
        }
    }
}
