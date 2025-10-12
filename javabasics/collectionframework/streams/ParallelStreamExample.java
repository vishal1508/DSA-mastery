package collectionframework.streams;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.stream.Stream;

public class ParallelStreamExample {
    public static void main(String[] args) {
        List<Integer> numList = Stream.iterate(1, x -> x+1).limit(20).toList();
        long startTime = System.currentTimeMillis();
        List<Integer> factorialList = numList.stream().map(ParallelStreamExample::factorial).toList();
        long EndTime = System.currentTimeMillis();

        long startTime1 = System.currentTimeMillis();
        List<Integer> factorialList1 = numList.parallelStream().map(ParallelStreamExample::factorial).sequential().toList();
        long EndTime1 = System.currentTimeMillis();

        //foreachorder
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7);
        System.out.println("parallel Strea print number using for each");
        numbers.parallelStream().forEach(x -> System.out.print(x));
        System.out.println();
        System.out.println("parallel Strea print number using for each order");
        numbers.parallelStream().forEachOrdered(x -> System.out.print(x));
        System.out.println();
        System.out.println(" time to get list :=> "+( EndTime- startTime));
        System.out.println(factorialList1 +" time to get list :=> "+( EndTime1- startTime1));

    }
    public static int factorial(int fact){
        int result = 1;
        for(int i = 2; i <= fact ; i++){
            result *= i;
        }
        return result;
    }
}
