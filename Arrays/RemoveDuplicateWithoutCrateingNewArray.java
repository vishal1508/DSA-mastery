public class RemoveDuplicateWithoutCrateingNewArray {
  public static void main(String[] args) {
    int a[] = { 5, 5, 7, 8, 8, 9, 9, 10, 10 };

    int x = 0;

    for (int i = 1; i < a.length - 1; i++) {
      if (a[x] != a[i]) {
        x = x + 1;
        a[x] = a[i];
      }

    }
    for (int i = 0; i < a.length - x; i++) {
      System.out.print(a[i] + ",");
    }
  }
}
