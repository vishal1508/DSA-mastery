package threadprac;

public class YieldMethod {
  public static void main(String[] args) {
    Mythread t1 = new Mythread("t1");
    Mythread t2 = new Mythread("t2");
    t1.start();
    t2.start();

  }
}

class Mythread extends Thread {

  Mythread(String name) {
    super(name);
  }

  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      System.out.println(Thread.currentThread().getName() + " => " + i);
      Thread.yield();
    }
  }

}

/*
 * without Yield
 * t2 => 0
 * t2 => 1
 * t2 => 2
 * t2 => 3
 * t1 => 0
 * t1 => 1
 * t1 => 2
 * t2 => 4
 * t1 => 3
 * t2 => 5
 * t1 => 4
 * t2 => 6
 * t1 => 5
 * t2 => 7
 * t1 => 6
 * t2 => 8
 * t1 => 7
 * t2 => 9
 * t1 => 8
 * t1 => 9
 */

/*
 * With Yeild
 * t1 => 0
 * t2 => 0
 * t1 => 1
 * t2 => 1
 * t1 => 2
 * t2 => 2
 * t1 => 3
 * t2 => 3
 * t1 => 4
 * t2 => 4
 * t1 => 5
 * t2 => 5
 * t1 => 6
 * t2 => 6
 * t2 => 7
 * t2 => 8
 * t1 => 7
 * t2 => 9
 * t1 => 8
 * t1 => 9
 */