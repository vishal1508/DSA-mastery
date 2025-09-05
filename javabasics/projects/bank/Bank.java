package projects.bank;

public class Bank {
  private double balance;
  static int totalAccounts;
  final String bankName = "SBI";

  public Bank(double balance) {
    if (balance < 2000) {
      System.out.println("Minimum BAlance Should be 2000 for Account Opening");
    } else {
      this.balance = balance;
      this.totalAccounts++;
    }
  }

  public double withdraw(double money) {
    if (this.balance > money) {
      this.balance = this.balance - money;
      System.out.println("your balance is := " + this.balance);
      return money;
    } else {
      System.out.println("your  not withdraw amount is greater than balance and your balance is := " + this.balance);
      return 0.0;
    }

  }

  public void deposite(double money) {
    if (money <= 0) {
      System.out.println("Deposite Money should be greater than 0");
    }
    this.balance += money;
  }

  public double getBalance() {
    return this.balance;
  }
}
