package collectionframework.streams.assignments;

import com.sun.source.tree.Tree;

import java.io.OutputStream;
import java.util.*;
import java.util.stream.Collectors;

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
                Arrays.asList(new Person(23,"Vishal"),new Person(23,"Akash"),new Person(22,"Kajal"))
                .stream()
                .collect(Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, Collectors.toList())));
                System.out.println(peopleByAgeTreeMap);

                //Output : {22=[Kajal], 23=[Vishal, Akash]}

    }
}

class Person{
    int age ;
    String name;

    Person(int age, String name){
        this.age = age;
        this.name = name;
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

    @Override
    public String toString() {
        return this.name+" : "+this.age;
    }
}