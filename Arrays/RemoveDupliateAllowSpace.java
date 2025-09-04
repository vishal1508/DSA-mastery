public class RemoveDupliateAllowSpace {
  public static void main(String[] args) {
    int oldArray[] = { 5, 5, 7, 8, 8, 9, 9, 10, 10 }; // intialize array

    int[] newArray = new int[oldArray.length]; // initialize new array with same size of old array

    newArray[0] = oldArray[0]; // here old array 0th value assign to new array 0th index
    int x = 0; // this is index for new array which is intailize with 0;
    for (int i = 1; i < oldArray.length - 1; i++) {
      if (newArray[x] != oldArray[i]) { // here is check newarray value is not eualto oldarray if it is yes then
                                        // increment x
        x = x + 1;
      }
      newArray[x] = oldArray[i]; // here old array 0th value assign to new array 0th index
    }
    for (int i : newArray) { // this print array using for each loop
      System.out.print(i + ",");
    }
    System.out.println("\nold Array length :=> " + oldArray.length + "\n newArray length :=> " + newArray.length);
  }
}
