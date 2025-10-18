package multithread;
class SetPriority extends Thread{
    SetPriority(String threadName){
        super(threadName);
    }
    @Override
    public void run() {
        try{
            for(int i = 0; i < 5; i++){
                System.out.println(Thread.currentThread().getName() +" Priority : "+Thread.currentThread().getPriority()+" Count : "+i);
            }
            System.out.println("Running");

        }catch(Exception e){
            System.out.println(e);
        }
    }
}
class InterruptExample extends  Thread{
    @Override
    public void run() {
        try{
         Thread.sleep(1000);
        System.out.println("Intrrupt Running");
        }catch(InterruptedException e){
            System.out.println("Thread is intrrupted while sleeping");
        }
    }
}
class YeildExample extends Thread{
    YeildExample(String threadName){
        super(threadName);
    }
    @Override
    public void run() {
        try{
            Thread.sleep(1000);
            for(int i = 0; i < 5; i++){
                System.out.println(Thread.currentThread().getName()+" is Running");
            }
            Thread.yield();
        }catch (Exception e){
            System.out.println("Exception");
        }
    }
}
public class MultiThreadEssentialMethodsExample extends Thread {


    public static void main(String[] args) throws InterruptedException {
        SetPriority low = new SetPriority("low");
        SetPriority medium = new SetPriority("medium");
        SetPriority high = new SetPriority("High");

        InterruptExample intterup = new InterruptExample();
        YeildExample task1 = new YeildExample("Task1");
        YeildExample task2 = new YeildExample("Task2");
        YeildExample task3 = new YeildExample("Task3");
        low.setPriority(MIN_PRIORITY);
        medium.setPriority(NORM_PRIORITY);
        high.setPriority(MAX_PRIORITY);

        low.start();
        medium.start();
        high.start();
        high.interrupt();


        intterup.start();
        intterup.interrupt();

        task1.start();
        task2.start();
        task3.start();

    }

}
