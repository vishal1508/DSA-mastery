package threadprac.locks;

public class LockMain {
  public static void main(String[] args) throws InterruptedException {
    BankAccount customer1 = new BankAccount();
    Mythread t1 = new Mythread(customer1, "user1", 700);
    Mythread t2 = new Mythread(customer1, "user2", 700);
    Thread c1 = new Thread(t1);
    Thread c2 = new Thread(t2);

    c1.start();
    c2.start();

    System.out.println("First coustomer Balnce :=  " + customer1.getBlance());

  }
}
