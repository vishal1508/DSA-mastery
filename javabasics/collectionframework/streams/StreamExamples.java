package collectionframework.streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
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

        //Filter method
        List<Integer> numberList = Arrays.asList(2,4,12,43,23,12,54,32);
        List<Integer> n  = numberList.stream().filter(nu -> nu % 2 == 0).toList();

        // Map method
        Stream<String> mapMethod = list.stream().map(x -> x.toUpperCase());
        System.out.println(mapMethod.collect(Collectors.toList()));

        //Sort method
        Stream<String> sortMethod = list.stream().sorted((a,b) -> a.compareTo(b));
        System.out.println(sortMethod.collect(Collectors.toList()));

        //For each method
        list.stream().forEach(System.out :: println);

        //reduce method
        Optional<Integer> reduceMethod =  numberList.stream().reduce((a, b) -> a + b);
        System.out.println(reduceMethod.get());

        // Convert Stream in to Collection or list
        List<Integer> numList = numberList.stream().toList();
        System.out.println(numList.get(0));

        // anyMatch method
        boolean anyMatchExample = numList.stream().anyMatch(x -> x % 2 == 0);
        System.out.println("is Any Match even number : = "+anyMatchExample);
        // all match
       boolean allMatchExample = numList.stream().allMatch(x -> x % 2 == 0);
        System.out.println("is All Match even number : = "+allMatchExample);
       // none match
        boolean noneMatch = numList.stream().noneMatch(x -> x % 2 == 0);

        System.out.println("is None Match even number : = "+noneMatch);
    }
}
