package collectionframework.queue;

import java.util.Comparator;
import java.util.concurrent.*;

class Producer implements Runnable{
    private BlockingQueue<Integer> blockingQueue;
    private int value = 0 ;
    Producer(BlockingQueue<Integer> blockingQueue){
        this.blockingQueue = blockingQueue;
    }
    @Override
    public void run() {
            while(true) {
            try{

                System.out.println("Produce value : = " + value);
                blockingQueue.put(value++);
                Thread.sleep(1000);

            }catch(Exception e){
                Thread.currentThread().interrupt();
                System.out.println("Cosumer Interrupt");
        }}
    }
}
class Cosumer implements Runnable{
    private BlockingQueue<Integer> blockingQueue;
    Cosumer(BlockingQueue<Integer> blockingQueue){
        this.blockingQueue = blockingQueue;
    }
    @Override
    public void run() {
        while(true){

        try{
            Integer value = blockingQueue.take();
            System.out.println("Cosume value : = "+value);
            Thread.sleep(2000);
        }catch(Exception e){
            Thread.currentThread().interrupt();
            System.out.println("Cosumer Interrupt");
        }
        }
    }
}

public class BlockingQueueExample {
    public static void main(String[] args) {
        // thread-safe
        // wait for queue to become non empty / wait for space
        // simplify cocurrency problem like producer-cosumer
        // standard queue
            // empty --> remove (no waiting)
            // full -->  add( no waiting)
        //Blocking queue
            // put --> Blocks if the queue is full untill space becomes available
            // take --> Blocks if the queue is empty until an element becomes available
            // offer --> waits for space to become available, up to the specified time out
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(5);

        // a bounded blocking queue backed by circular array
        // low memory overhead
        // uses a single lock for both enqueue and deque opeartion
        // more threads --> problem
        Thread produce = new Thread(new Producer(blockingQueue));
        Thread cosume = new Thread(new Cosumer(blockingQueue));

//        produce.start();
//        cosume.start();

        BlockingQueue<Integer> blockingQueue1 = new LinkedBlockingQueue<>();
        // Optionally Bounded backed by Linked List
        // uses two separate locks for enqueue and dequeue operations
        // Higher Concurrency between producers and Consumers.

        BlockingQueue<String> blockingQueue2 = new PriorityBlockingQueue<>(11, Comparator.reverseOrder());
        // Binary Heap as a Array and Can Grow dynamically
        // Heads are Ordered base on there natural ordering or a provided Comparator like Priority Queue
        // put wnats block

        blockingQueue2.add("apple");
        blockingQueue2.add("banana");
        blockingQueue2.add("cherry");
        System.out.println(blockingQueue2);


        BlockingQueue<Integer> blockingQueue3 = new SynchronousQueue<>();
        //each insert Operation must wait for corresponding remove operation by anothe threa and vice versa
        // it cannot store element, capacity of at most one element
        try{
        blockingQueue3.offer(1);
        System.out.println(blockingQueue3);

        }catch (Exception e){
            System.out.println(e.toString());
        }

    }
}
