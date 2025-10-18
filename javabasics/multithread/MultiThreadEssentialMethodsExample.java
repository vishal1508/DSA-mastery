package multithread;

public class MultiThreadEssentialMethodsExample extends Thread {
    MultiThreadEssentialMethodsExample(String threadName){
        super(threadName);
    }
    @Override
    public void run() {
        for(int i = 0; i < 5; i++){
            System.out.println(Thread.currentThread().getName() +" Priority : "+Thread.currentThread().getPriority()+" Count : "+i);
        }
        System.out.println("Running");
    }
    public static void main(String[] args) throws InterruptedException {
        MultiThreadEssentialMethodsExample low = new MultiThreadEssentialMethodsExample("low");
        MultiThreadEssentialMethodsExample medium = new MultiThreadEssentialMethodsExample("medium");
        MultiThreadEssentialMethodsExample high = new MultiThreadEssentialMethodsExample("High");

        low.setPriority(MIN_PRIORITY);
        medium.setPriority(NORM_PRIORITY);
        high.setPriority(MAX_PRIORITY);

        low.start();
        medium.start();
        high.start();
        Thread.sleep(2000);

    }

}
