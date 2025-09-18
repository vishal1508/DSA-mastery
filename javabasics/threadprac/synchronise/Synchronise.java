package threadprac.synchronise;

public class Synchronise {
  public static void main(String[] args) throws InterruptedException {
    CounnNumber cn = new CounnNumber();
    MyThread t1 = new MyThread(cn);
    MyThread t2 = new MyThread(cn);

    Thread newThread = new Thread(t1);
    Thread newThread2 = new Thread(t2);

    newThread.start();
    newThread2.start();
    newThread.join();
    newThread2.join();
    System.out.println("Total Count is :=> " + cn.getCount());
  }
}

class MyThread implements Runnable {

  private CounnNumber countNumber;

  MyThread(CounnNumber countNumber) {
    this.countNumber = countNumber;
  }

  @Override
  public void run() {
    for (int i = 0; i < 10000; i++) {
      countNumber.incrementCount();
    }
  }

}

class CounnNumber {
  private int count;

  public void incrementCount() {
    this.count++;
  }

  public int getCount() {
    return this.count;
  }

}
