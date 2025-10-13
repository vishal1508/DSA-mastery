package collectionframework.streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class PrimitiveStram {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5};
        IntStream stream = Arrays.stream(numbers);
        System.out.println(stream);
        System.out.println(IntStream.range(1,5).boxed().collect(Collectors.toList()));
        System.out.println(IntStream.rangeClosed(1,5).boxed().collect(Collectors.toList()));
        System.out.println(IntStream.of(1,2,3).boxed().toList());


        //Double
        DoubleStream doubleStream = new Random().doubles(5);
        System.out.println(doubleStream.boxed().toList());
    }
}
