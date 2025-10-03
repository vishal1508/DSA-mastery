package javabasics.collectionframework.list.hashmaps;

import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHashMapExample {
  public static void main(String[] args) {
    Map<String, Integer> h = new IdentityHashMap<>();

    h.put(new String("Vishal"), 1);
    h.put(new String("Vishal"), 2);

    System.out.println(h);
  }
}
