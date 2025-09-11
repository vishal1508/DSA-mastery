package exception;

public class ArrayOutOfBoundException {
  public static void main(String[] args) {
    int a[] = { 1, 2, 3, 4 };
    for (int i = 0; i < 10; i++) {
      try {
        System.out.println(a[i]);
      } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println(e);
      }
    }
  }
}
