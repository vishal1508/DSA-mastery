// Maximum Sub Array Problem | Native Approach OR Base Approach
public class MaximumSubArray {
  public static void main(String[] args) {
    int a[] = { 3, 8, 2, 5, 7, 6, 12 };

    int maxx = Integer.MIN_VALUE;
    int w = 4;
    for (int i = 0; i <= w - 1; i++) {
      int current = 0;
      for (int j = i; j <= i + w - 1; j++) {
        current = current + a[j];
      }
      maxx = max(current, maxx);
    }
    System.out.println("Maximumn number of Subarray is :=> " + maxx);
  }

  public static int max(int a, int b) {
    if (a > b) {
      return a;
    } else {
      return b;
    }
  }

}
