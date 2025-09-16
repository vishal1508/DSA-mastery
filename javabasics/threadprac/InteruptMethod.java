package threadprac;

public class InteruptMethod {
  public static void main(String[] args) {
    Mythread t1 = new Mythread();
    t1.start();
    t1.interrupt(); // interrupt the thread from running
  }
}

class Mythread extends Thread {

  @Override
  public void run() {
    System.out.println("Running");
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      System.out.println(e);
    }
  }

}
