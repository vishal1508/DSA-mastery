package collectionframework.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MethodReferenceExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("Apple","Mango"));
        list.forEach(System.out :: println);
    }

}
