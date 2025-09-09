package projects.payment;

import java.util.Scanner;

public class SmartPaymentSystem {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    Payment.showSupportedPayments();

    System.out.println("Choose payment method (1=UPI, 2=Credit Card, 3=Debit Card, 4=Wallet): ");
    int choice = sc.nextInt();
    sc.nextLine(); // consume newline

    Payment payment = null;

    switch (choice) {
      case 1:
        System.out.print("Enter UPI ID: ");
        String upi = sc.nextLine();
        payment = new UPIPayment(upi);
        break;
      case 2:
        System.out.print("Enter Card Number: ");
        String ccNum = sc.nextLine();
        System.out.print("Enter Card Holder: ");
        String ccHolder = sc.nextLine();
        payment = new CreditCardPayment(ccNum, ccHolder);
        break;
      case 3:
        System.out.print("Enter Card Number: ");
        String dcNum = sc.nextLine();
        System.out.print("Enter Card Holder: ");
        String dcHolder = sc.nextLine();
        payment = new DebitCardPayment(dcNum, dcHolder);
        break;
      // case 4:
      // System.out.print("Enter Wallet ID: ");
      // String wallet = sc.nextLine();
      // payment = new WalletPayment(wallet);
      // break;
      default:
        System.out.println("Invalid choice!");
        sc.close();
        return;
    }

    // Functional Interface with Lambda
    TransactionValidator validator = (amt) -> amt > 0 && amt < 100000;

    System.out.print("Enter amount to pay: ");
    double amount = sc.nextDouble();

    if (!validator.validate(amount)) {
      System.out.println("Invalid amount!");
      sc.close();
      return;
    }

    // Apply discount if available
    if (payment instanceof Discount) {
      amount = ((Discount) payment).applyDiscount(amount);
      System.out.println("Amount after discount: " + amount);
    }

    if (payment.pay(amount)) {
      payment.printReceipt(amount);
    }

    // Refund option
    if (payment instanceof Refundable) {
      System.out.print("Do you want a refund? (yes/no): ");
      String ans = sc.next();
      if (ans.equalsIgnoreCase("yes")) {
        ((Refundable) payment).refund(amount);
      }
    }

    // Check for secure payment
    if (payment instanceof SecurePayment) {
      System.out.println("This is a secure payment method ✅");
    }

    sc.close();
  }
}
