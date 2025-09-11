package exception;

public class ArithmeticException {
  public static void main(String[] args) {
    int[] a = { 2, 3, 4, 5 };
    int[] b = { 1, 2, 0, 4 };
    for (int i = 0; i < a.length; i++) {
      try {
        System.out.println(a[i] / b[i]);
      } catch (java.lang.ArithmeticException e) {
        System.out.println(e);
      }
    }
  }
}
