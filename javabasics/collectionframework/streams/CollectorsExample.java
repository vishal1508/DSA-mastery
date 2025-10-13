package collectionframework.streams;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsExample {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,2,4,4,3,4,5);
        List<String> names = Arrays.asList("Vishal","Hello","World","Beautiful","India","Cat","Dog","Apple");
        // Collecting  to a list
        System.out.println(nums.stream().filter( x -> x % 2 == 0).collect(Collectors.toList()));

        // Collecting to a set
        System.out.println(nums.stream().collect(Collectors.toSet()));

        // Collect to a Specific collection
        List<String> specificCollection = nums.stream().map(x -> String.valueOf(x)).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(specificCollection);

        // join methdo
        System.out.println(names.stream().collect(Collectors.joining(",  ")));

        //summerizing
        IntSummaryStatistics num = nums.stream().collect(Collectors.summarizingInt(x -> x));
        System.out.println("Max : "+num.getMax());
        System.out.println("average : "+num.getAverage());
        System.out.println("minimum := "+num.getMin());

        // Averagimg
        Double avg = nums.stream().collect(Collectors.averagingDouble(x -> x));
        System.out.println("averaging := "+avg);

        //Counting Elements
        Long count = nums.stream().collect(Collectors.counting());
        System.out.println("Counting :=> "+count);

        //Groupping
        System.out.println(names.stream().collect(Collectors.groupingBy(t -> t.length())));
        System.out.println(names.stream().collect(Collectors.groupingBy(t -> t.length(),Collectors.joining(", "))));
        System.out.println(names.stream().collect(Collectors.groupingBy(t -> t.length(),Collectors.counting())));
        TreeMap<Integer,Long> treeMap = names.stream().collect(Collectors.groupingBy(t -> t.length(),TreeMap::new,Collectors.counting()));
        System.out.println(treeMap);

        //partitioning
        System.out.println(names.stream().collect(Collectors.partitioningBy(x -> x.length() > 5)));
        // Mapping
        System.out.println(names.stream().collect(Collectors.mapping(x -> x.toUpperCase(), Collectors.toList())));
    }
}
