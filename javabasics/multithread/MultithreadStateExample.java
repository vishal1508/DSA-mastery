package multithread;

public class MultithreadStateExample extends  Thread {

    @Override
    public void run() {
//        System.out.println("RUNNING");
        try {
            System.out.println("State 4 : "+Thread.currentThread().getState());
            Thread.sleep(2000);
            System.out.println("State 5 : "+Thread.currentThread().getState());
        }catch(InterruptedException e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) throws InterruptedException{
        MultithreadStateExample m = new MultithreadStateExample();
        System.out.println("State 1 : "+m.getState());
        m.start();
        System.out.println("State 2 : "+m.getState());
        Thread.sleep(1000);
        System.out.println("State 3 : "+m.getState());
        m.join();
        System.out.println("State 6 : "+m.getState());
    }
}

