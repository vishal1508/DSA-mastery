package collectionframework.list.arraylist.arraylistpractice;

import java.util.ArrayList;

public class Practice2 {
  public static void main(String[] args) {
    // Create a list of names, sort them, and print top 3 names alphabetically.
    ArrayList<String> names = new ArrayList<>();

    names.add("vishal");
    names.add("rajesh");
    names.add("suresh");
    names.add("rajat");
    names.add("shubham");
    names.add("vikas");

    names.sort(null);

    for (int i = 0; i < 3; i++) {
      System.out.println(names.get(i));
    }

  }
}
