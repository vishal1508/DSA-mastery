package projects.payment;

public interface Payment {

  public static double MIN_AMOUNT = 1.0;

  boolean pay(double amount);

  String getPaymentDetails();

  default void printReceipt(double amount) {
    System.out.println("Paid " + amount + "  using UPI");
    System.out.println("---- Receipt ----");
    System.out.println("Details := " + getPaymentDetails());
    System.out.println("===================");

  }

  static void showSupportedPayments() {
    System.out.println("Supported Payments: UPI, Credit Card, Debit Card, Wallet");

  }
}
