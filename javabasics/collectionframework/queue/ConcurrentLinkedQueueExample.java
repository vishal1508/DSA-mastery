package collectionframework.queue;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueExample {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        Thread producer = new Thread(() -> {
            while(true){
                try{
                    System.out.println("Waiting to produce a task...");
                    concurrentLinkedQueue.add("task"+System.currentTimeMillis());
                }catch (Exception e){
                    Thread.currentThread().interrupt();
                    System.out.println("Producer Interrupted");
                }
            }
        });
        Thread consumer = new Thread(() -> {
           while(true){
               try{
                   System.out.println("Waiting to produce a task...");
                   String message = concurrentLinkedQueue.poll();
                   System.out.println("Consume task : = "+message);
               }catch (Exception e){
                   Thread.currentThread().interrupt();
                   System.out.println("Producer Interrupted");
               }
           }
        });

        producer.start();
        consumer.start();
     }
}
