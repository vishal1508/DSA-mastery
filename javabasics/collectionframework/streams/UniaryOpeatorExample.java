package collectionframework.streams;

import java.util.function.UnaryOperator;

public class UniaryOpeatorExample {
    public static void main(String[] args) {
        UnaryOperator<Integer> un = n -> n * 2;
        System.out.println(un.apply(2));
    }
}
