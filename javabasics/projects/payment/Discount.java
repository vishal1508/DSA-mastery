package projects.payment;

public interface Discount {
  default double applyDiscount(double amount) {

    return 0.90 * amount;
  }
}
