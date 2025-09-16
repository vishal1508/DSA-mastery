package threadprac;

public class SetPriorityMethod {
  public static void main(String[] args) {
    Mythread l = new Mythread("Low Priority");
    Mythread m = new Mythread("Medium Priority");
    Mythread h = new Mythread("High Priority");

    l.setPriority(1);
    m.setPriority(5);
    h.setPriority(10);

    l.start();
    m.start();
    h.start();
  }
}

class Mythread extends Thread {

  public Mythread(String name) {
    super(name);
  }

  @Override
  public void run() {
    for (int i = 0; i < 5; i++) {
      try {
        Thread.sleep(2000);
        System.out.println(
            Thread.currentThread().getName() + " - Priority " + Thread.currentThread().getPriority() + " count " + i
                + "\n");
      } catch (InterruptedException e) {
        System.out.println(e);
      }
    }
  }

}