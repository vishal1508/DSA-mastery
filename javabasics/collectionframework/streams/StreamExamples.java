package collectionframework.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamExamples {
    public static void main(String[] args) {
        //Create a Stream From Collection
        List<String> list = Arrays.asList("Vishal","Amey","Raju");
        Stream<String> stream = list.stream();
        // Create Stream From Array
        String[] s = {"Vishal","Vinay"};
        Stream<String> arrayStream = Arrays.stream(s);

        // Create a Stream  using Stream.of
        Stream<String> usingStream = Stream.of("Vishal","Vikas");

        // Create Infinite Stream using Generate
        Stream<Integer> infinteStreamUsingGenerate = Stream.generate( () -> 1).limit(100);

        // Create Infinte Stream using Iterator
        Stream<Integer> countNumber = Stream.iterate(1,x -> x + 1).limit(100);
        System.out.println(countNumber.count());

    }
}
