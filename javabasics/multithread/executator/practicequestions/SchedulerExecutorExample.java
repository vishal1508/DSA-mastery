package multithread.executator.practicequestions;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SchedulerExecutorExample {
    public static void main(String[] args) {
        /*
        5. ScheduledExecutorService
        Goal: Use ScheduledExecutorService to print "Hello" every 2 seconds for 10 seconds, then stop gracefully.
👉           Concepts: scheduleAtFixedRate(), scheduling, graceful shutdown.
        */
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        long startTime = System.currentTimeMillis();
        Runnable task = () -> System.out.println("Task executed at: " + (System.currentTimeMillis() - startTime));


        System.out.println("Scheduling task...");
        scheduler.schedule(task, 3, TimeUnit.SECONDS); // run after 3 seconds

        scheduler.shutdown();
    }
}
