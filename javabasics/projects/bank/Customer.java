package projects.bank;

public class Customer {
  public static void main(String[] args) {
    Bank b = new Bank(4000);
    b.deposite(2000);
    System.out.println(b.getBalance());
    b.deposite(2000);
    System.out.println(b.getBalance());
    System.out.println(b.withdraw(3000));
    Bank b1 = new Bank(3000);

    System.out.println(b1.getBalance());
    System.out.printf("total Accounts of %s is := %d", b.bankName, Bank.totalAccounts);
  }
}
