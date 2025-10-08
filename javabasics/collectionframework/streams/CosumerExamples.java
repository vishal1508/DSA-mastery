package collectionframework.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class CosumerExamples {
    public static void main(String[] args) {
        Consumer<String> c = a -> System.out.println(a);
        c.accept("Hello World");

        Consumer<Integer> isEvenOdd = a -> {
            if(a % 2 == 0){
            System.out.println(a+ " : Event ");
            }else{
                System.out.println(a+ " : Odd ");

            }
        };
        for(int i = 1; i <=5 ; i++){
            isEvenOdd.accept(i);
        }


        Consumer<List<Integer>> l = a -> {
            for(int i = 0; i < a.size();i++){
                a.set(i,a.get(i) * 2);
            }
            System.out.println("After Double := "+a);

        };

        List<Integer> a = new ArrayList<>(Arrays.asList(1,2,3));
        System.out.println("Before Double := "+a);
        l.accept(a);

        Consumer<String> trimString = p -> System.out.println(p.trim());
        Consumer<String> toUpperCaseString = p -> System.out.println(p.toUpperCase());

        Consumer<String> chainingConsumer = trimString.andThen(toUpperCaseString);

        chainingConsumer.accept("vishal ");

        Consumer<List<String>> sl = cl -> cl.removeIf( f -> f.toLowerCase().startsWith("a"));
        Consumer<List<String>>  listToUpperCase = lu -> {
//          for(String s : lu){  dont use if space not matter , we can use normal for loop to set  or update exisitng string
//              s.toUpperCase();
//          }
            for (int i = 0; i < lu.size(); i++) {
                lu.set(i, lu.get(i).toUpperCase());
            }
          System.out.println("After List is : "+lu);
        };
        Consumer<List<String>> combineFunction = sl.andThen(listToUpperCase);
        List<String> list = new ArrayList<>(Arrays.asList("Vishal", "Amit", "Raju", "Anita", "Suresh"));

        combineFunction.accept(list);
    }
}
