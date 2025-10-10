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
        System.out.println(usingStream);

    }
}
