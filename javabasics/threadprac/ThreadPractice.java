package threadprac;

public class ThreadPractice {
  public static void main(String[] args) throws InterruptedException {
    Mythread t1 = new Mythread(); // new state
    System.out.println(t1.getState());
    t1.start(); // Runnable state
    System.out.println(t1.getState());
    Thread.sleep(100);
    System.out.println(t1.getState());
    t1.join();
    System.out.println(t1.getState());
  }
}

class Mythread extends Thread {

  @Override
  public void run() {
    System.out.println("RUNNING");
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      System.out.println(e);
    }
  }

}
