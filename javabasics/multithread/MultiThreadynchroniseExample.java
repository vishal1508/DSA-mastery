package multithread;

public class MultiThreadynchroniseExample {
    public static void main(String[] args) {
        Counter count = new Counter();
        CounterThread counterThread1 = new CounterThread(count);
        CounterThread counterThread2 = new CounterThread(count);

        counterThread1.start();
        counterThread2.start();

        try{
            counterThread1.join();
            counterThread2.join();
        }catch(Exception e){

        }
        System.out.println(count.getCount());
    }
}
class CounterThread extends Thread{
    private Counter count;

    CounterThread(Counter count){
        this.count = count;
    }
    @Override
    public void run() {
        for(int i = 1; i <= 1000; i++){
            count.incrementCount();
        }
    }
}
class Counter{
    int count;

    public int getCount(){
        return this.count;
    }
    public synchronized void incrementCount(){
        this.count++;
//        this.count = count;
    }
}
