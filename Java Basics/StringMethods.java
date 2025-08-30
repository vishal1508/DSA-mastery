public class StringMethods {
  public static void main(String[] args) {
    String s = "RAM";   // Interned string, stored in String Pool
    String a = "RAM";   // Same interned reference as "s"
    String d = "RA";    // Different string, new entry in String Pool

    System.out.println(s == a); // ✅ true (same reference from String Pool)
    System.out.println(s == d); // ✅ false (different string in pool)
    System.out.println("s address: " + System.identityHashCode(s) + ", value: " + s);
    System.out.println("a address: " + System.identityHashCode(a) + ", value: " + a);

    String x = new String("RAM");  // Creates a NEW object in heap
    System.out.println("x address: " + System.identityHashCode(x) + ", value: " + x);

    String y = new String("RAM");  // Creates ANOTHER new object in heap
    System.out.println("y address: " + System.identityHashCode(y) + ", value: " + y);

    System.out.println(x == y); // ❌ false (different heap objects, even though same content)
  }
}
