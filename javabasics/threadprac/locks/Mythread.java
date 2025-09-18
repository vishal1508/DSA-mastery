package threadprac.locks;

public class Mythread implements Runnable {
  private BankAccount ba;
  private String name;
  private int amount;

  public Mythread(BankAccount ba, String name, int amount) {
    this.ba = ba;
    this.name = name;
    this.amount = amount;
  }

  @Override
  public void run() {
    ba.withdrawnAmount(name, amount);
  }

}
