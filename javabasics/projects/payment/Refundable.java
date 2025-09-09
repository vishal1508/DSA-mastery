package projects.payment;

public interface Refundable {
  boolean refund(double amount);

  default double applyDiscount(double amount) {
    return amount * 0.5;
  }
}
