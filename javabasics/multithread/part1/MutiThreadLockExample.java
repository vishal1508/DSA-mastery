package multithread.part1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
    Q2.Thread-safe Counter using Lock
    Same as above but implement thread safety using ReentrantLock.
*/
public class MutiThreadLockExample {
    public static void main(String[] args) {
        CounterLock counter = new CounterLock();

        Runnable increment = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " Procesing ");
                for (int i = 1; i <= 1000; i++) {
                    counter.increment();
                }
            }
        };

        Thread t1 = new Thread(increment, "Task1");
        Thread t2 = new Thread(increment, "Task2");
        t1.start();
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        t2.start();

        try {
            t1.join();
            t2.join();
            System.out.println(counter.getCounter());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

class CounterLock {
    int counte = 0;
    private final Lock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        try {
            Thread.sleep(1);
            this.counte++;
        } catch (InterruptedException e) {
            System.out.println(e);
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    public int getCounter() {
        return this.counte;
    }
}


