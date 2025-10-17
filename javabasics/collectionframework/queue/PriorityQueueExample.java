package collectionframework.queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((x,y) -> y - x);
        // part of the queue interface
        // order elements base on their natural ordering
        // custom comparator for Cutomised ordering
        // dose not allow null element
        priorityQueue.add(1);
        priorityQueue.add(30);
        priorityQueue.add(15);
        priorityQueue.add(2);
//        priorityQueue.add(null);
        System.out.println(priorityQueue);
        while (!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.poll());
        }
    }
}
