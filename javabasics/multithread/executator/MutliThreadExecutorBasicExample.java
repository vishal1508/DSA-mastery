package multithread.executator;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MutliThreadExecutorBasicExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(9);
        for (int i = 1; i < 10; i++) {
            int finali = i;
            executorService.submit(() -> {
                long result = factorial(finali);
                System.out.println(result);
            });
        }
        executorService.shutdown();
    }

    public static long factorial(int i) {
        int result = 1;
        for (int x = 1; x <= i; x++) {
            result *= x;
        }
        return result;
    }
}
