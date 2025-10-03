package javabasics.collectionframework.list.copyonwritearraylists;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayLists {
  public static void main(String[] args) {
    List<String> a = new CopyOnWriteArrayList<>();
    a.add("fruits");
    a.add("eggs");
    a.add("chicken");
    a.add("Oats");
    for (String s : a) {
      if (s.equals("eggs")) {
        a.add(2, "Butter");
      }
    }
    System.out.println(a);
  }
}
