package multithread.part1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReenterantLockExample {
    /*
        Q5. Reentrant synchronized method
            Demonstrate that a thread can re-enter a synchronized method it already holds the lock for..
    */
    public static void main(String[] args) {
        Renterant r = new Renterant();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                r.outerLock();
            }
        };

        Thread t1 = new Thread(task);

        t1.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Renterant {
    private final Lock lock = new ReentrantLock();

    public void outerLock() {
        lock.lock();
        try {
            System.out.println("Outer lock Called");
            innerLock();
        } catch (Exception e) {
            Thread.currentThread().interrupt();
            System.out.println(Thread.currentThread().getName() + " is Interrupted");
        } finally {
            lock.unlock();
        }
    }

    public void innerLock() {
        lock.lock();
        try {
            System.out.println("innerLock Called");
        } catch (Exception e) {
            Thread.currentThread().interrupt();
            System.out.println(Thread.currentThread().getName() + " is Interrupted");
        } finally {
            lock.unlock();
        }
    }
}