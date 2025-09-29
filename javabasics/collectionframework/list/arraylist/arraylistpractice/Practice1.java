package collectionframework.list.arraylist.arraylistpractice;

import java.util.*;

public class Practice1 {
  // Create an ArrayList of integers and remove all even numbers using iterator.
  public static void main(String[] args) {
    ArrayList<Integer> num = new ArrayList<>();

    for (int i = 1; i <= 10; i++) {
      num.add(i);
    }
    num.removeIf(s -> s % 2 == 0);

    System.out.println(num);

  }
}
