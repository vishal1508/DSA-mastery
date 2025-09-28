package collectionframework.list;

import java.util.*;

public class Arraylist {
  public static void main(String[] args) {
    ArrayList<Integer> arrayList = new ArrayList<Integer>(); // create array list
    ArrayList<Integer> arrayList_copy = new ArrayList<Integer>(); // create array list
    arrayList_copy.add(15);
    arrayList_copy.add(16);
    arrayList_copy.add(17);

    arrayList.ensureCapacity(12);
    for (int i = 1; i <= 10; i++) {
      arrayList.add(i); // add element end of the list
    }

    // add methods

    arrayList.add(0, 12);
    // this add have two parameter to pass which is index and data or value, if u
    // pass index but not value is set to null , but index not be null or not empty

    arrayList.addFirst(13);
    // addFirst is to add element before start of the list , when add element using
    // this function everytime it add before start list

    arrayList.addLast(14);
    // this addLast Function add Element at the end of list , it accept null also

    arrayList.addAll(arrayList_copy);
    // this addAll Function add seperate arrayList or collection array in other
    // arraylist at the end of list like join to current

    arrayList.addAll(5, arrayList_copy);
    // this addAll function haveing two parameters is index and value , we can
    // whole collection in any index exixting value will shited towards

    arrayList.set(5, 18);
    // this set function to update existing value using index

    // remove methods
    arrayList.remove(5); // this remove value by passing index
    arrayList.remove(14); // this remove value by passing value
    arrayList.removeAll(arrayList_copy);
    // this remove collection by passing collection which exist in current list
    arrayList.removeFirst(); // this removeFirst remove first Element from list
    arrayList.removeLast(); // this removeFirst remove first Element from list
    // arrayList.removeIf(a -> a < 5); // this remove if method remove all element
    // which statisfy the condition

    arrayList.sort(null); // this sort function sort the arraylist base on value, this function pass
                          // Comparator class which has serveral method to multiple sort method to sort
                          // arrayList

    System.out.println(arrayList);
    System.out.println(arrayList.contains(5)); // this contains method is check that element is exist in list if is
                                               // exist return true otherwise false
    System.out.println(arrayList.containsAll(arrayList_copy)); // this function can compare whole array with other array
  }
}
