package multithread.executator.practicequestions;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/*4. Handling Task Exceptions

Goal: Submit multiple tasks where one throws an exception.
Catch and handle the exception gracefully using Future.get().
        👉 Concepts: Exception propagation, checked exceptions in threads.*/
public class HandlingTaskExceptionExampleExecutor {
    public static void main(String[] args) {
        int tn = 0;
        ExecutorService executorService = Executors.newFixedThreadPool(2);
            int n = tn;
        Future<Integer> task1 = executorService.submit(() -> {
            return 10/n;
        });
        Future<Integer> task2 =  executorService.submit(() -> {
            return 10/10;
        });

        try {
            Integer nt = task1.get();
            System.out.println(nt);
        } catch (ExecutionException e) {
            Throwable original = e.getCause(); // This is the actual exception thrown in the task
            System.out.println("Task failed because: " + original);
            if(original instanceof ArithmeticException){
                System.out.println("Retrying with safe denominator = 1");
                Future<Integer> retryTask = executorService.submit(() -> 10 / 1);
                try {
                    System.out.println("Retry Result: " + retryTask.get());
                } catch (Exception retryEx) {
                    System.out.println("Retry also failed: " + retryEx.getMessage());
                }
            }
        }catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Handle interruption
        }
        try {
            System.out.println("Task 2 Result: " + task2.get());
        } catch (Exception e) {
            System.out.println("Task 2 failed: " + e.getMessage());
        }
        executorService.shutdown();
    }
}
