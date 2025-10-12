package collectionframework.streams;

import java.lang.reflect.Array;
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
        List<Integer> numberList = Arrays.asList(1,2,2,4,4,12,43,23,12,54,32);
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

        //Firstmatch
        int firstMatch = numList.stream().findFirst().get();
        System.out.println("Find First := "+firstMatch);
        int findAnyExample = numList.stream().filter(x -> x % 2 == 0).findAny().get();
        System.out.println("Find Any := "+findAnyExample);

        //Examples
        // Filtering and collecting name
        List<String> CollectName  = list.stream().filter(x -> x.length() < 5).toList();
        System.out.println(CollectName);

        // Example : Squaring and sorted numbers
        List<Integer> sortedSquareNumber = numberList.stream().map(x -> x*x).sorted().toList();
        System.out.println(sortedSquareNumber);

        //Example : Summing Values
        int sum = numberList.stream().reduce(Integer::sum).get();
        System.out.println("sum : => "+sum);

        //Countion Occurence of Character
        String name = "Hello World";
        Long charCount = name.chars().filter(x -> x == 'l').count();
        System.out.println(charCount);

        //skip
        Stream<Integer> skipNumber = numberList.stream().skip(2);
        System.out.println(skipNumber.toList());

        //distinct
        Stream<Integer> distinctNumber = numberList.stream().distinct();
        System.out.println(distinctNumber.toList());
        //flatmap
        List<List<String>> listoflist = Arrays.asList(Arrays.asList("apple","banana"),Arrays.asList("Kiwi","Pinapple"));
        System.out.println(listoflist.stream().flatMap( f -> f.stream().map(st -> st.toUpperCase())).toList());
        List<String> str =Arrays.asList("Hello World","India is the Biggest Country");
        System.out.println(str.stream().flatMap(st -> Arrays.stream(st.split(" "))).map(xt -> xt.toUpperCase()).toList());

    }

}
