package collectionframework.list.arraylist.arraylistpractice;

import java.lang.reflect.*;
import java.util.ArrayList;

public class Practice3 {
  public static void main(String[] args) throws Exception {
    // Add 20 elements in an ArrayList with initial capacity = 5, check how many
    // times it resizes.

    ArrayList<Integer> elem = new ArrayList<>(5);

    Field field = ArrayList.class.getDeclaredField("elementData");
    System.out.println(field);
    field.setAccessible(true);
    int oldCapacity = ((Object[]) field.get(elem)).length;
    System.out.println("Initial capacity: " + oldCapacity);

    for (int i = 1; i <= 20; i++) {
      elem.add(i);
      int newCapacity = ((Object[]) field.get(elem)).length;

      if (newCapacity != oldCapacity) {
        System.out.println("Resize at element " + i + "\n new Capacity is :=> " + newCapacity);
        oldCapacity = newCapacity;
      }
    }
  }
}
