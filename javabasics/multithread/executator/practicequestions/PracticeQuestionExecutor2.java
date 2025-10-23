package multithread.executator.practicequestions;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*Goal: Create a fixed thread pool with 3 threads using Executors.newFixedThreadPool().
Submit 10 tasks and print which thread executes each task.
        👉 Concepts: Thread reuse, task distribution.*/
public class PracticeQuestionExecutor2 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for(int i = 0; i < 10; i++){
            int taskId = i;
            executorService.submit(() -> {
                System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });

        }
        executorService.shutdown();
    }
}
