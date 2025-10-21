package multithread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MultiThreadLockExample {
    public static void main(String[] args) {
        Bank b = new Bank();
        Runnable withdrawAmountThread = new Runnable() {
            @Override
            public void run() {
                b.withdraw(10);
            }
        };
        Thread t1 = new Thread(withdrawAmountThread, "Thread 1");
        Thread t2 = new Thread(withdrawAmountThread, "Thread 2");
        Thread t3 = new Thread(withdrawAmountThread, "Thread 3");
        t1.start();
        t2.start();
        t3.start();
    }
}

class Bank {
    private int balance = 4000;

    private final Lock lock = new ReentrantLock();

    public void withdraw(int withDrawAmount) {

        System.out.println(Thread.currentThread().getName() + " Attempt to Start Withdraw " + withDrawAmount);
        try {


            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {

                if (this.balance >= withDrawAmount) {
                    try {
                        Thread.sleep(10000);
                    System.out.println(Thread.currentThread().getName() + " Proceeding with withdraw");
                    this.balance -= withDrawAmount;
                    System.out.println(Thread.currentThread().getName() +" With Drawl has Successfully Completed\nRemaing balance is : " + this.balance);
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }finally {
                        lock.unlock();
                    }
                } else {
                    System.out.println("Insufficient balance");
                }
            } else {
                System.out.println(Thread.currentThread().getName()+" Could Not Aquire Lock will try again");
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Thread is Interrupt or not : "+Thread.currentThread().isInterrupted());
    }

    public int getBalance() {
        return balance;
    }
}
