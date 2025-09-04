public class MaximumSubArrayNumSlidingWindow {
  public static void main(String[] args) {
    int current = 0; // current intialize with 0
    int a[] = { 3, 8, 2, 5, 7, 6, 12 };
    int w = 4; // windows size
    for (int i = 0; i < w; i++) {
      current = current + a[i]; // calculate current value still window size is 4
    }
    int maxx = current;
    for (int i = 1; i <= a.length - w; i++) {
      current = current - a[i - 1] + a[i + w - 1]; // calculate current value
      if (current > maxx) { // here is check is current is greater than maxx if yes then assign current
                            // value to maxx till a.length - w
        maxx = current;
      }
    }
    System.out.println("Using sliding window Maximum sub array sum is := " + maxx);
  }
}
