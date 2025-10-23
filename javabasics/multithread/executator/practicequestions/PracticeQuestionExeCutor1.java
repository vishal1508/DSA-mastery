package multithread.executator.practicequestions;


/*
Goal: Create a program that uses an ExecutorService to run 5 simple Runnable tasks that each print the current thread name.
        👉 Concepts: ExecutorService, execute(), shutdown().
*/

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PracticeQuestionExeCutor1 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            int taskId = i;
            executorService.execute(() -> {
                System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName());
            });
        }
        executorService.shutdown();
    }
}
