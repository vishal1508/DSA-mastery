package multithread.part2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MultithreadingTryLockWithTime {
    public static void main(String[] args) {
        final Lock lock = new ReentrantLock();
        Runnable task = new Runnable() {
            int count = 0;

            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + " acquired the lock");
                    if (lock.tryLock(2000, TimeUnit.MILLISECONDS)) {
                        try {

                            Thread.sleep(3000);
                            for (int i = 0; i < 1000; i++) {
                                count++;
                            }
                            System.out.println(Thread.currentThread().getName() + " Process completed" + count);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        } finally {
                            lock.unlock();
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName() + " failed to acquire lock");
                    }
                } catch (Exception e) {
                    System.out.println(e);
                    System.out.println(Thread.currentThread().getName() + " is interrupted");
                }
            }
        };

        Thread t1 = new Thread(task, "Task1");
        Thread t2 = new Thread(task, "Task2");
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

