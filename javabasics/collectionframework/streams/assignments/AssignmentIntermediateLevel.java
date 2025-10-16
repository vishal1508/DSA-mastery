package collectionframework.streams.assignments;

import com.sun.source.tree.Tree;

import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AssignmentIntermediateLevel {
    public static void main(String[] args) {
        // Find the sum of squares of all even numbers in a list.
        // Input : [1,2,3,4,5,6,7,8]
        System.out.println(Arrays.asList(1,2,3,4,5,6,7,8).stream().filter( x-> x %2 == 0).map(x -> x * x).reduce(0,Integer::sum));
        // Output : 120

        // Given a list of strings, join them into a single comma-separated string.
        // Input : ["Hello","World"]
        System.out.println(Arrays.asList("Hello","World").stream().collect(Collectors.joining(", ")));
        // Output : Hello, World

        // Given a list of words, count how many start with a vowel.
        // Input : "Vishal","Ashish","Arjun","Akansha"
        System.out.println(Arrays.asList("Vishal","Ashish","Arjun","Akansha","Ekta").stream().filter(x -> x != null && Set.of('a','e','i','o','u').contains(Character.toLowerCase(x.charAt(0)))).toList());
        // Output : [Ashish, Arjun, Akansha, Ekta]

        // Find the average of a list of integers using streams.
        // Input : [1,2,4,2]
        System.out.println(Arrays.asList(1,2,4,2).stream().collect(Collectors.averagingInt(x -> x)));
        //Output :  2.25

        //Given a list of names, collect them into a Set using Collectors.toSet().
        //  Input : ["Vishal","Ajay"]
        Set<String> newSet = Arrays.asList("Vishal","Ajay").stream().collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println(newSet);
        // Output : [Vishal, Ajay]

        //Sort a list of strings in reverse alphabetical order using streams.
        // Input : ["Babita","Vishal","Adarsh"]
        System.out.println(Arrays.asList("Babita","Vishal","Adarsh").stream().sorted(Comparator.reverseOrder()).toList());
        // Output : [Vishal, Babita, Adarsh]

        // Count how many times each word occurs in a list (word frequency map).
        // input : ["Hello","World","Java","Hello","World"]
        System.out.println(Arrays.asList("Hello","World","Java","Hello","World").stream().collect(Collectors.toMap(x -> x, y -> 1, (a,b) -> a+b)));
        // Output : {Java=1, Hello=2, World=2}

        //Group a list of people by their age using Collectors.groupingBy().
        Map<Integer, List<String>> peopleByAgeTreeMap =
                Arrays.asList(new Person(1,23,"Vishal",23234.23),new Person(2,23,"Akash",23434.32),new Person(3,22,"Kajal",234.34))
                .stream()
                .collect(Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, Collectors.toList())));
                System.out.println(peopleByAgeTreeMap);

                //Output : {22=[Kajal], 23=[Vishal, Akash]}


        // Partition a list of integers into even and odd numbers using partitioningBy().
        // Input : [1,2,3,4,5,6,6,7]
        System.out.println(Arrays.asList(1,2,3,4,5,6,6,7).stream().collect(Collectors.partitioningBy(x -> x % 2 == 0)));
        // Output :     {false=[1, 3, 5, 7], true=[2, 4, 6, 6]}

        // Flatten a list of lists (e.g., List<List<Integer>>) into a single list using flatMap().
        // Input : [[1,2,3,4],[5,6,7,8,9]]
        System.out.println(Arrays.asList(Arrays.asList(1,2,3,4), Arrays.asList(5,6,7,8,9)).stream().flatMap(f -> f.stream()).toList());
        // Output : [1, 2, 3, 4, 5, 6, 7, 8, 9]

         //Get a distinct list of characters from a list of strings.
        // Input : ["java","stream","api"]
        System.out.println(Stream.of("java","stream","api").flatMap(s -> s.chars().mapToObj(x -> (char) x)).toList());
        // Output : [j, a, v, a, s, t, r, e, a, m, a, p, i]

        // Find the second highest number in a list using streams.
        // Input : [1,2,3,4,5,6,7]
        System.out.println(Arrays.asList(1,2,3,4,5,6,7).stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(0));
        // Output : 6

        //Given a list of employee objects, find the one with the highest salary.

        System.out.println(Arrays.asList(new Person(1,23,"Vishal",23000.23),new Person(2,23,"Akash",343444.123))
                .stream()
                .max(Comparator.comparing(x -> x.getSal())).get().toString()
        );
        //Output : name := Akash
        //Age := 23
        //Salary := 343444.123

        // Convert a list of objects into a Map with key = ID and value = name.
        System.out.println(Arrays.asList(new Person(1,23,"Vishal",23000.23),new Person(2,23,"Akash",343444.123))
                .stream().collect(Collectors.toMap(x -> x.getId(),y -> y.getName()))
        );
        // Output : {1=Vishal, 2=Akash}


        //Count the number of occurrences of each character in a string using streams.
        // Input : "Java Stream API"
        Map<Character,Integer> newMap = Stream.of("Java Stream Api".toLowerCase().split(" ")).flatMap(x -> x.chars().mapToObj(ch -> (char)ch)).collect(Collectors.toMap(x -> x,y -> 1,Integer::sum,LinkedHashMap::new));
        System.out.println(newMap);
        // {J=1, a=3, v=1, S=1, t=1, r=1, e=1, m=1, A=1, p=1, i=1}
    }
}

class Person{
    int age ;
    String name;
    double sal ;
    int id;

    Person(int id,int age, String name,double sal){
        this.age = age;
        this.name = name;
        this.sal = sal;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "\nname := "+this.name+"\nAge := "+this.age+"\nSalary := "+this.sal+"\n";
    }
}