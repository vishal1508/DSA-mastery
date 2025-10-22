package multithread.part2;
/*
    Q7.One thread holds a lock; another thread tries to acquire it using lockInterruptibly()
    and is interrupted after some time.
*/

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MultiThreadInteruptabilityExample {
    public static void main(String[] args) {
        BankAccountInteruuptability b = new BankAccountInteruuptability(1000);
        Runnable withDrawTask = new Runnable() {
            @Override
            public void run() {
                b.withdraw(500);
            }
        };
        Runnable depositeTask = new Runnable() {
            @Override
            public void run() {
                b.deposite(1500);
            }
        };

        Thread t1 = new Thread(withDrawTask);
        Thread t2 = new Thread(depositeTask);

        t1.start();
        try {
            Thread.sleep(500);
            t2.start();

            Thread.sleep(2000);
            t2.interrupt();
            t1.join();
            t2.join();
            System.out.println("Balnace :== " + b.getBalance());
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " is interupt");
        }

    }
}

class BankAccountInteruuptability {
    private int balance;
    private final Lock lock = new ReentrantLock();

    BankAccountInteruuptability(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void withdraw(int amount) {
        try {
            lock.lockInterruptibly();

            if (this.balance > amount) {
                try {
                    System.out.println(Thread.currentThread().getName() + " Processint to Withdraw");
                    Thread.sleep(5000);
                    this.balance -= amount;
                    System.out.println(Thread.currentThread().getName() + " Withdrawm Process is Completed");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println(Thread.currentThread().getName() + " is interrupted");
                } finally {
                    lock.unlock();
                }

            } else {
                System.out.println(Thread.currentThread().getName() + " Insufficent balance");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(Thread.currentThread().getName() + " is interrupted");
        }
    }

    public void deposite(int amount) {
        try {
            lock.lockInterruptibly();


            try {
                System.out.println(Thread.currentThread().getName() + " Processint to Deposite");
                Thread.sleep(5000);
                this.balance += amount;
                System.out.println(Thread.currentThread().getName() + " Deposite Process is Completed");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(Thread.currentThread().getName() + " is interrupted");
            } finally {
                lock.unlock();
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(Thread.currentThread().getName() + " is interrupted");

        }
    }
}
