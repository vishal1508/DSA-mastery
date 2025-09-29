package collectionframework.list.arraylist.arraylistpractice;

import java.util.ArrayList;

public class Practice4 {
  public static void main(String[] args) {
    // Merge two ArrayLists into one.

    ArrayList<Integer> a1 = new ArrayList<>();
    ArrayList<Integer> a2 = new ArrayList<>();

    for (int i = 1; i <= 5; i++) {
      a1.add(i);
    }
    for (int i = 6; i < 11; i++) {
      a2.add(i);
    }

    a1.addAll(a2);
    System.out.println(a1);
  }
}
