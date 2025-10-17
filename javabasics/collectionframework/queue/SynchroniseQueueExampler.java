package collectionframework.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class SynchroniseQueueExampler {
    public static void main(String[] args) {
        BlockingQueue<String> synchroniseBlockingQueue = new SynchronousQueue<>();

        Thread produce = new Thread( () -> {
                try{
                    System.out.println("Producer is waiting to transfer ");
                    synchroniseBlockingQueue.put("Hello World");
                    System.out.println("Producer has tranfer the message");

                }catch(Exception e){
                    Thread.currentThread().interrupt();
                    System.out.println("Producer was interrupted");
                }

        }) ;
        Thread cosumer = new Thread( () -> {
                try{
                    System.out.println("Consumer is waiting to recieve ");
                    String message = synchroniseBlockingQueue.take();
                    System.out.println("Cosnumer Recieved := "+message);

                }catch(Exception e){
                    Thread.currentThread().interrupt();
                    System.out.println("Cosnumer was interrupted");
                }

        }) ;
        produce.start();
        cosumer.start();


    }
}
