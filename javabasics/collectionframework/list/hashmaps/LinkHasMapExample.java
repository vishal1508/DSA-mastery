package javabasics.collectionframework.list.hashmaps;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkHasMapExample {
  public static void main(String[] args) {
    LRUCache<String, Integer> students = new LRUCache<>(3);
    students.put("Vishal", 10);
    students.put("Rajesh", 20);
    students.put("Dipak", 13);
    students.put("Ganesh", 45);

    students.put("Vishal", 34);
    for (Map.Entry<String, Integer> e : students.entrySet()) {
      System.out.println(e.getKey() + " : " + e.getValue());
    }
  }
}

class LRUCache<K, V> extends LinkedHashMap<K, V> {
  int capacity;

  public LRUCache(int capacity) {
    super(capacity, 0.75f, true);
    this.capacity = capacity;
  }

  @Override
  protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
    return size() > capacity;
  }

}
