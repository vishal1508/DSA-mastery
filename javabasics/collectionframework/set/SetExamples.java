package collectionframework.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;

public class SetExamples {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(67);
        set.add(1);
        set.add(12);
        set.add(3);
        System.out.println(set);

        // order set value
        Set<Integer> linkHashSet = new LinkedHashSet<>();
        linkHashSet.add(2);
        linkHashSet.add(1);
        linkHashSet.add(3);
        System.out.println(linkHashSet);

        // Sorted Set using tree set
        Set<Integer> treeSet =  new TreeSet<>();
        treeSet.add(67);
        treeSet.add(1);
        treeSet.add(3);
        treeSet.add(2);
        System.out.println(treeSet);;

//        copyOnEriteSet and Copyskpilistset
        ConcurrentSkipListSet<Integer> concurrentSkipListSet = new ConcurrentSkipListSet<>();

        concurrentSkipListSet.add(30);
        concurrentSkipListSet.add(10);
        concurrentSkipListSet.add(20);

        System.out.println(concurrentSkipListSet); // [10, 20, 30]

        System.out.println(concurrentSkipListSet.lower(25));   // 20
        System.out.println(concurrentSkipListSet.ceiling(15)); // 20

        concurrentSkipListSet.pollFirst(); // removes 10
        System.out.println(concurrentSkipListSet); // [20, 30]
    }
}
