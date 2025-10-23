package multithread.executator.practicequestions;

import java.util.Random;
import java.util.concurrent.*;

public class CallableAndFutureExamplePracticeQuestion {
    /*
        Callable + Future
        Goal: Create 3 Callable<Integer> tasks that each return a random number.
            Use submit() and Future.get() to collect and print all results.
            👉 Concepts: Callable, Future, async result handling.
    */
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            int TaskId = i;
            Future<Integer> RandomNumber = executorService.submit(() -> {
                System.out.print("Task " +TaskId+ " executed by " + Thread.currentThread().getName());
                return generateRandomNumber();
            });

            try {

               int randomNumber = RandomNumber.get();
                System.out.println(" Random Number := " + randomNumber);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        executorService.shutdown();
    }

    public static int generateRandomNumber() {
        Random rand = new Random();  // creating a new Random
        return rand.nextInt(100);
    }
}
