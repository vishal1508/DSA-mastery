package collectionframework.streams.assignments;

import collectionframework.streams.CollectorsExample;

import java.text.CollationKey;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Assignment1 {
    public static void main(String[] args) {
        // Create a stream from a list of integers and print all elements.
        List<Integer> list = new ArrayList<>(Arrays.asList(12,2,3,6,4,5));
        List<String> names = Arrays.asList("Vishal","Amey","Raju","Charan","Arati","Ananya");

        list.stream().forEach(System.out :: print);

        //Find the count of elements in a stream.
        System.out.println("\nCount : = "+list.stream().count());

        //Given a list of strings, filter and print only those that start with the letter "A".
        // INPUT : ["Vishal","Amey","Raju","Charan","Arati","Ananya"]
        System.out.println("Names is Start with A := "+names.stream().filter(x -> x.toUpperCase().startsWith("A")).collect(Collectors.toList()));
        // Names is Start with A := [Amey, Arati, Ananya]

        //Convert all strings in a list to uppercase using streams.
        // INPUT : ["Vishal","Amey","Raju","Charan","Arati","Ananya"]
        System.out.println(names.stream().map(String::toUpperCase).collect(Collectors.toList()));
        // OUTPUT : [VISHAL, AMEY, RAJU, CHARAN, ARATI, ANANYA]

        //Sort a list of numbers using Stream API.
        // Input : [1,2,3,6,4,5]
        System.out.println(list.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList()));
        // Output  : [1, 2, 3, 4, 5, 6]

        //Given a list of integers, print only even numbers.
        // Input : [1,2,3,6,4,5]
        System.out.println(list.stream().filter(x -> x %2 == 0).collect(Collectors.toList()));
        // Output : [2, 6, 4]

        // Find the minimum and maximum elements from a list using Stream API.
        // Input : [12,2,3,6,4,5]
        IntSummaryStatistics sumeries = list.stream().mapToInt(Integer::valueOf).summaryStatistics();
        System.out.println("Minimum := "+sumeries.getMin());
        System.out.println("Maximum := "+sumeries.getMax());
        /*
        Output :
                Minimum := 2
                Maximum := 12
        */


        // Sum all numbers in a list using reduce().
        // Input : [12,2,3,6,4,5]
        System.out.println("Sum of numbers from list is :=> "+list.stream().reduce(0,Integer::sum));
        // Output : Sum of numbers from list is :=> 32

        //Check if all elements in a list are even.
        // Input : [12,2,3,6,4,5]
        System.out.println(list.stream().allMatch(x -> x % 2 == 0));
        // output : false

        // Check if any element in a list is negative.
        // Input : [12,2,3,6,4,5]
        System.out.println(list);
        System.out.println(list.stream().anyMatch(x -> x < 0));
        // Output : false

        // Convert a list of strings into a list of their lengths.
        // Input : ["Vishal","Amey","Raju","Charan","Arati","Ananya"]
        System.out.println(names.stream().map(x -> x.length()).toList());
        // Output : [6, 4, 4, 6, 5, 6]

        // Remove duplicates from a list using streams.
        // Input : [1,2,3,2,4,4]
        System.out.println(Arrays.asList(1,2,3,2,4,4).stream().distinct().collect(Collectors.toList()));
        // Output : [1, 2, 3, 4]

        // Limit a stream to the first 5 elements and print them.
        System.out.println(Stream.iterate( 1, (x) -> x + 1).limit(5).toList());
        // Output :  [1, 2, 3, 4, 5]

        //Skip the first 3 elements in a stream and print the rest.
        // Input : [1,2,3,4,5,6,7]
        System.out.println(Arrays.asList(1,2,3,4,5,6,7).stream().skip(3).toList());
        // Output : [4, 5, 6, 7]

        //Find the first element in a list using findFirst().
        // Input : [1,2]
        System.out.println(Arrays.asList(1,2).stream().findFirst().orElse(0));
        // Output : 1
    }
}
