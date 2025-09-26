
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadAndWrite {
  public static void main(String[] args) throws InterruptedException {
    Bank b = new Bank(10000);
    MyThread1 thread1 = new MyThread1(b);
    MyThread2 thread2 = new MyThread2(b);

    Thread t3 = new Thread(thread1, "t3");
    Thread t1 = new Thread(thread2, "t1");
    Thread t2 = new Thread(thread2, "t2");
    Thread t4 = new Thread(thread2, "t4");

    t1.start();
    t2.start();
    t3.start();
    t4.start();

    t1.join();
    t2.join();

    t3.join();
    t4.join();
  }

}

class Bank {
  private int balance;
  private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
  private final Lock readLock = lock.readLock();
  private final Lock writeLock = lock.writeLock();

  public Bank(int balance) {
    this.balance = balance;
  }

  public void deposite(int amount) {
    writeLock.lock();
    try {
      if (amount > 0) {
        this.balance += amount;
        System.out.println(Thread.currentThread().getName() + " current balance is :=> " + this.balance);
        Thread.sleep(1000);
        System.out.println("");
      }
    } catch (InterruptedException e) {
      System.out.println(e.getStackTrace());
    } finally {
      writeLock.unlock();
    }
  }

  public void readBalnce() {
    readLock.lock();
    try {
      Thread.sleep(1000);
      System.out.println(Thread.currentThread().getName() + " current balance is :=> " + this.balance);
    } catch (Exception e) {
    } finally {
      readLock.unlock();
    }
  }
}

class MyThread1 implements Runnable {
  private Bank bank;

  public MyThread1(Bank bank) {
    this.bank = bank;
  }

  @Override
  public void run() {
    bank.deposite(10000);
  }
}

class MyThread2 implements Runnable {
  private Bank bank;

  public MyThread2(Bank bank) {
    this.bank = bank;
  }

  @Override
  public void run() {
    bank.readBalnce();
  }
}
