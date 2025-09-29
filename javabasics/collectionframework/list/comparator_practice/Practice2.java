package collectionframework.list.comparator_practice;

import java.util.ArrayList;

public class Practice2 {
  public static void main(String[] args) {
    // Use a Comparator with lambda to sort integers in descending order.
    ArrayList<Integer> numbers = new ArrayList<>();
    numbers.add(12);
    numbers.add(10);
    numbers.add(13);
    numbers.add(22);
    numbers.add(42);

    numbers.sort((n1, n2) -> Integer.compare(n2, n1));

    System.out.println(numbers);

  }
}
