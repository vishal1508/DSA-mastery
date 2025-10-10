package collectionframework.streams;

import java.util.function.BinaryOperator;

public class BinaryOperatorExample {
    public static void main(String[] args) {
        BinaryOperator<Integer> bn = (a,b) -> a+b;
        System.out.println("Addition is :=> "+bn.apply(3,4));
    }
}
