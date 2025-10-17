package collectionframework.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class DoubleEndedQueueExample {
    public static void main(String[] args) {
        //Double Ended Queue
        // allow Insertion and Deletion of elements From Both Ends

        /*
        * Insertion Method
        * addFirst - Inserts the specified elemtent at the Front
        * addLast - Inserts the specified elemtent at the End
        * offerFirst - Inserts the specified elemtent at the Front if Possible
        * offerLast - Inserts the specified elemtent at the End if Possible
        * */

        /*
        * Removeal Method
        * removeFirst - Retrievers and removes the first element.
        * removeLast - Retrievers and remove the last element.
        * pollFirst - Retrievers and removes the first element. or return null if empty
        * pollLast - Retrievers and removes the Last element. or return null if empty
        */

        /*
        * Examination Methods
        * getFirst - Retrives, but does not remove, the first element.
        * getLast - Retrives, but does not remove, the Last element.
        * peekFirst - Retrives, but does not remove, the First element. or return null if empty
        * peekLast - Retrives, but does not remove, the Last element. or return null if empty
        * */

        /*
        * Stack Methods
        * push - Adds the element at the front (Equivalent to addFirst)
        * pop - Removes and return the first element(equivalent to removeFirst)
        *  */

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(2);
        deque.add(1);
        deque.addFirst(3);
        deque.addLast(5);
        System.out.println(deque);
        System.out.println("First Element : = "+deque.peek());
        System.out.println("Last Element : = "+deque.peekLast());
        deque.poll();
        deque.pollLast();
        System.out.println(deque);
        for(int i : deque){
            System.out.println(i);
        }
        Deque<Integer> deque1 = new LinkedList<>();
        deque1.add(2);
        deque1.add(1);
        deque1.addFirst(3);
        deque1.addLast(5);
        System.out.println(deque1);
        System.out.println("First Element : = "+deque1.peek());
        System.out.println("Last Element : = "+deque1.peekLast());
        deque1.poll();
        deque1.pollLast();
        System.out.println(deque1);
        for(int i : deque1){
            System.out.println(i);
        }
    }
}
