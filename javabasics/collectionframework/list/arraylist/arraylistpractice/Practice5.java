package collectionframework.list.arraylist.arraylistpractice;

import java.util.*;

public class Practice5 {
  public static void main(String[] args) throws Exception {
    // Convert ArrayList to array and vice versa.

    ArrayList<Integer> a = new ArrayList<Integer>();
    System.out.println("Arraylist := " + a);
    a.add(1);
    Integer array[] = a.toArray(new Integer[0]);
    System.out.println("ArrayList convert into array :=> " + array[0]);

    Integer[] ar = new Integer[3];
    ar[0] = 1;
    ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(ar));
    System.out.println("array convert into arrayList :=> " + arr);
    // System.out.println(arr);/
  }
}
