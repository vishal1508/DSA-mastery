package multithread.executator;

public class MultithreadExample {
    public static void main(String[] args) {
        Thread[] thread = new Thread[9];
        long startTIme = System.currentTimeMillis();

        System.out.println("Start time :=> "+startTIme);
        for (int i = 1; i < 10; i++) {
            int finali = i;
            thread [i - 1] = new Thread(() -> {

            long result = factorial(finali);
            System.out.println(result);
            });
            thread[i-1].start();
        }
        for(Thread t : thread){
            try {
                t.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(" System tinme : "+System.currentTimeMillis()+"\nstart time := "+ startTIme+ "\nTotal time,"+(System.currentTimeMillis() - startTIme));
    }

    public static int factorial(int i) {
        int result = 1;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        for (int n = 1; n <= i; n++) {
            result *= n;
        }
        return result;
    }


}

