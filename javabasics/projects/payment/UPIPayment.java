package projects.payment;

public class UPIPayment implements Payment, Refundable, Discount {
  private String upiId;

  public UPIPayment(String upiId) {
    this.upiId = upiId;
  }

  @Override
  public boolean pay(double amount) {
    if (amount < MIN_AMOUNT) {
      System.out.println("Amount too small!");
      return false;
    }
    System.out.println("Paid " + amount + " using UPI: " + upiId);
    return true;
    // TODO Auto-generated method stub
  }

  @Override
  public String getPaymentDetails() {
    // TODO Auto-generated method stub
    return "UPI ID: " + upiId;
  }

  @Override
  public boolean refund(double amount) {
    // TODO Auto-generated method stub
    System.out.println("Refunded " + amount + " via UPI: " + upiId);
    return true;
  }

  @Override
  public double applyDiscount(double amount) {
    System.out.println("Applying custom discount for UPI...");
    return Discount.super.applyDiscount(amount); // choose 10%
  }
}