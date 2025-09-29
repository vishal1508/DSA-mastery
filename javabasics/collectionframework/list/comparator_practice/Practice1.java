package collectionframework.list.comparator_practice;

import java.util.ArrayList;
import java.util.Comparator;

public class Practice1 {
  public static void main(String[] args) {
    // Sort a list of strings by length instead of alphabetical order.
    ArrayList<String> names = new ArrayList<>();
    names.add("vishal");
    names.add("Rajesh");
    names.add("Kamal");
    names.add("Ankureee");
    names.add("Arjun");

    names.sort(new MyComparator());
    System.out.println("Names := " + names);

  }
}

class MyComparator implements Comparator<String> {

  @Override
  public int compare(String o1, String o2) {
    if (o2.length() - o1.length() > 0) {
      return 1;
    } else if (o2.length() - o1.length() < 0) {
      return -1;
    }
    return 0;
  }

}
