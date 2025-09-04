public class StringMethods {
  public static void main(String[] args) {
    String s = "RAM";   // Interned string, stored in String Pool
    String a = "RAM";   // Same interned reference as "s"
    String d = "RA";    // Different string, new entry in String Pool

    // System.out.println(s == a); // ✅ true (same reference from String Pool)
    // System.out.println(s == d); // ✅ false (different string in pool)
    // System.out.println("s address: " + System.identityHashCode(s) + ", value: " + s);
    // System.out.println("a address: " + System.identityHashCode(a) + ", value: " + a);

    // String x = new String("RAM");  // Creates a NEW object in heap
    // System.out.println("x address: " + System.identityHashCode(x) + ", value: " + x);

    // String y = new String("RAM");  // Creates ANOTHER new object in heap
    // System.out.println("y address: " + System.identityHashCode(y) + ", value: " + y);

    // System.out.println(x == y); // ❌ false (different heap objects, even though same content)
  
    String b = "Car";
    String c = "car";
         System.out.println("b address1: " + System.identityHashCode(b) + ", value: " + b);

    System.out.println("Length of B :=> "+b.length()); // Length() method  retrun length of string
    System.out.println("Length of C :=> "+c.charAt(0)); // charAt() method return charatcter value of perticular index  from String 
    System.out.println("b is equal to C :=> "+ b.equals(c)); // equals() method to check two string value is exact equal example (car).equals(Car) = false , eauals method check alphabetical case also
    System.out.println("c is equal to  b :=> "+c.equalsIgnoreCase(b)); // equalsIgnoreCase()  method to check string value except case 
    int com = b.compareTo(c);
    int comIgn = b.compareToIgnoreCase(c);
    System.out.println("Compare method :=> "+ com); // compareTo() method check each character is strict equal( if first string  char is c is upper case and other string char c is lowercase the that give value was greater than o or less that o that means is not equal ), (if output is 0 that means that two string is equal)
    
    System.out.println("CompareToIgnoreCase method : => "+comIgn); // compareTo() method check each character is equal( if first string  char is c is upper case and other string char c is lowercase the that give 0 means that two string is equals)
    String carName = "Ferrari";
    System.out.println("Sub String method :=> "+carName.substring(2,4)); // Sub String method return value from start index to end index and end index is exclude


    System.out.println("Lower Case :=> "+b.toLowerCase()); // toLowerCase() method is return all string value to lower case
    System.out.println("Upper Case :=> "+b.toUpperCase()); // toUpperCase() method is return all string value to Upper case
    String name = "S  Vishal Kerlekar";
    System.out.println("Trim method :=> "+name.trim()); // remove starting and ending spaces from string
    System.out.println("Replace method :=> "+ "older value of String is :=> "+name+" After Replace Vishal to Ramesh value is :=>  "+ name.replace("Vishal", "Ramesh"));
    System.out.println("Contains method :=> "+ name.contains("V")); // contains method to check that string or character is have in that string value if is exist then return true if not return false  Strictly follow case
    System.out.println("Starts With method :=> "+name.startsWith("s")); // startsWith() method to check in string first index letter is match with given letter if match return true else false strictly follow alphabetical cases like uppercase and lowercase 
    System.out.println("ends With method :=> "+name.endsWith("r")); // endsWith() method to check in string last index letter is match with given letter if match return true else false strictly follow alphabetical cases like uppercase and lowercase 
    String ismpt = " asd";
    System.out.println("isEmpty method :=> "+ismpt.isEmpty());// isEmpty method is to check that string length is 0 if it is 0 then return true if greater than 0 return false
    System.out.println("isBlank method :=> "+ismpt.isBlank());// isBlank method is to check that string have a blank space   // java 11 feature // this method return true if have any string other than empty space
  
    System.out.println("index of method :=> "+ name.indexOf('r')); //indexOf() method is return of the index value of first occurence
    System.out.println("index of method :=> "+ name.lastIndexOf('r')); //indexOf() method is return of the index value of last occurence
    System.out.println("value of method :=> "+String.valueOf(1).getClass().getSimpleName());

    System.out.println("String Format :=> "+String.format("my name is %s and i am Software Engineer at %s", "Vishal","Google")); // String.format() this method work like printf in this method pass string , and arguments
  }
}
