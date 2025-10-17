package collectionframework.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueExample {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.remove();
        queue.offer(2);
        queue.poll();
        System.out.println(queue);

        Queue<Integer> arrayBlockQueue = new ArrayBlockingQueue<>(2);
        arrayBlockQueue.add(1);
        arrayBlockQueue.add(2);
        arrayBlockQueue.offer(3);
        System.out.println(arrayBlockQueue);

    }
}
