package collectionframework.streams;

import java.util.*;

public class LambdaExpressionExample {
    public static void main(String[] args) {
        PrintStatement op = () -> System.out.println("Hello World");
        op.sayHello();
        PrintSquare sq = (a) -> System.out.println(a * a);
        System.out.print("square is. :=> ");
        sq.calculateSquare(10);

        Addition ad = (a, b) -> a + b;
        System.out.println("Addition is : => " + ad.calculateAddition(10, 20));

        UpperCaseString ups = (s) -> System.out.println(s.toUpperCase());
        ups.toUpperCaseString("Vishal");

        EvenCheck ec = (a) -> a % 2 == 0;
        System.out.println(ec.isEven(13) ? "is Even" : "is Not Even");

        Calculate addition = (a, b) -> a + b;
        Calculate subtraction = (a, b) -> a - b;
        Calculate multiplication = (a, b) -> a * b;
        Calculate division = (a, b) -> a / b;

        System.out
                .println("Addition : => " + addition.calculate(10, 2) +
                        "\nSubtraction : => " + subtraction.calculate(10, 2) +
                        "\nMultiplication : => " + multiplication.calculate(10, 2) +
                        "\nDivision : => " + division.calculate(10, 2));

    List<String> l = Arrays.asList("vishal","Ramesh","Raju","Suresh");
    l.sort((l1,l2) -> l1.compareTo(l2));

    List<Integer> li = new ArrayList<>(Arrays.asList(1,2,3,12,23,15,14,11,10,4,5,6,9,8));
   li.removeIf( n -> n < 10);
   li.sort(null);
  System.out.println(li);
    }
}

interface PrintStatement {
    void sayHello();
}

interface PrintSquare {
    void calculateSquare(int a);
}

interface Addition {
    int calculateAddition(int a, int b);
}

interface UpperCaseString {
    void toUpperCaseString(String a);
}

interface EvenCheck {
    boolean isEven(int a);
}

interface Calculate {
    int calculate(int a, int b);
}
