package projects.payment;

public class DebitCardPayment implements Payment {

  private String cardNumber;
  private String cardHolder;

  public DebitCardPayment(String cardHolder, String cardNumber) {
    this.cardNumber = cardNumber;
    this.cardHolder = cardHolder;
  }

  @Override
  public boolean pay(double amount) {
    if (amount < MIN_AMOUNT) {
      System.out.println("Amount too small!");
      return false;
    }
    System.out.println("Paid " + amount + " using Debit Card: " + cardNumber);
    return true;
  }

  @Override
  public String getPaymentDetails() {
    return "Card: " + cardNumber + ", Holder: " + cardHolder;
  }
}
