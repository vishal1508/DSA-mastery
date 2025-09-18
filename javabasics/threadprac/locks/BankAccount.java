package threadprac.locks;

import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
  private int balance = 1000;

  private final ReentrantLock lock = new ReentrantLock();

  public void withdrawnAmount(String name, int amount) {
    lock.lock(); // 🔒 User2 इथे थांबतो जर lock व्यस्त असेल

    try {
      if (amount <= balance) {
        System.out.println(name + " trying to withdraw " + amount);
        System.out.println(name + " proceeding with withdrawal...");
        Thread.sleep(500); // simulate delay
        this.balance -= amount;
        System.out.println(name + " completed withdrawal. Remaining balance = " + this.balance);

      } else {
        System.out.println(name + " cannot withdraw. Insufficient funds.");
      }
    } catch (InterruptedException e) {
      System.out.println(e);
    } finally {
      lock.unlock();
    }

  }

  public int getBlance() {
    return this.balance;
  }
}
