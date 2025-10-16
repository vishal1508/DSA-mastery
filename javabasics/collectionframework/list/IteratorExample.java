package collectionframework.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratorExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);


        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            if(iterator.next() % 2 == 0){
                iterator.remove();
            }
        }
        ListIterator<Integer> listIterator = list.listIterator();
        while (listIterator.hasNext())
        {
            if(listIterator.next() % 2 != 0){
                listIterator.add(2);
            }
        }
        System.out.println(list);


    }
}
