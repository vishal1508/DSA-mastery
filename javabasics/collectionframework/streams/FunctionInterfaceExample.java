package collectionframework.streams;

import java.util.function.Function;

public class FunctionInterfaceExample {
    public static void main(String[] args) {
        Function<String ,String>  f = a -> a;
        Function<Integer ,String>  printNumber = a -> "Number is : "+a;
        Function<String ,Integer>  stringLength = a -> a.length();
        Function<String ,String>  reverseString = a -> {
            String reverse = "";
            for(int i = a.length() - 1; i >=0; i--){
                reverse+=a.charAt(i);
            }
            return reverse;
        };
        Function<Integer, Integer> getSquare = a -> a*a;
        Function<Integer, String> getPrint = a -> "Result is"+a;
        Function<Integer,String> composeFunction = getSquare.andThen(getPrint);


        System.out.println(f.apply("Hello World"));
        System.out.println(printNumber.apply(2));
        System.out.println("Then length of give String is : "+stringLength.apply("Vishal"));
        System.out.println("Then Reverse of give String is : "+reverseString.apply("Vishal"));
        System.out.println(composeFunction.apply(5));


    }
}
