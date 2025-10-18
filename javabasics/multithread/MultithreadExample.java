package multithread;

public class MultithreadExample {
    public static void main(String[] args) {
        World world = new World();
        Thread t1 = new Thread(world);
        t1.start();
        for (int i = 0; i < 1000 ;i++ ) {
            System.out.println("Hello");
        }
    }
}
class World extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 1000 ;i++ ) {
            System.out.println("World");
        }
    }
}class World2 implements Runnable{
    @Override
    public void run() {
        for(;;){
            System.out.println("World");
        }
    }
}
