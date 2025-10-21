package multithread.part1;

import java.util.List;
import java.util.Stack;

/*
    Q4.Simple Producer-Consumer using synchronized
    Implement a producer-consumer pattern with a shared buffer, using synchronized, wait(), and notify().
*/



public class MultiThreadProducerConsumerSyncroniseWaitNotifiyExample {
    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource(10);
        Runnable producerTask = new Runnable() {
            @Override
            public void run() {
                shareResource.producer();
            }
        };
        Runnable cosumerTask = new Runnable() {
            @Override
            public void run() {
                shareResource.consumer();
            }
        };

        Thread t1 = new Thread(producerTask, "Producer");
        Thread t2 = new Thread(cosumerTask, "Consumer");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Interupted");
        }

    }
}

class ShareResource {
    int bufferSize = 3;
    int limit = 10;
    int num = 1;
    List<Integer> l = new Stack<>();

    ShareResource(int limit) {
        this.limit = limit;
    }

    public synchronized void producer() {
        while (true) {
            while (this.bufferSize == l.size()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            l.add(num);
            System.out.println(Thread.currentThread().getName() + " adds : " + num + " -> " + l);
            num++;
            notifyAll();

            if (l.isEmpty() || !(num < limit)) break;
        }
    }

    public synchronized void consumer() {

        while (true) {
            while (l.isEmpty()) {
                try {
                    System.out.println(Thread.currentThread().getName() + " is Waiting");
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            int removeElement = l.remove(0);
            System.out.println(Thread.currentThread().getName() + " removes : " + removeElement + " -> " + l);
            notifyAll();

            if (l.isEmpty() && num >= limit) break;
        }

    }
}
