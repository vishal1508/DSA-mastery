package multithread.part2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MultiThreadDeadLockExample {
    public static void main(String[] args) {
        Pen pen = new Pen();
        Paper paper = new Paper();

        Runnable penTask = new Runnable() {
            @Override
            public void run() {
                pen.writeWithPenAndPaper(paper);
            }
        };
        Runnable paperTask = new Runnable() {
            @Override
            public void run() {
                paper.writeWithPenAndPaper(pen);
            }
        };

        Thread t1 = new Thread(penTask,"thread A");
        Thread t2 = new Thread(paperTask,"thread B");

        t1.start();
        t2.start();
    }
}

class Pen{
    public synchronized  void writeWithPenAndPaper(Paper paper)
    {
        System.out.println(Thread.currentThread().getName()+" is Using Pen"+this+" is trying to use paper"+paper);
        paper.finishWriting();

    }
    public synchronized  void finishWriting(){
        System.out.println(Thread.currentThread().getName()+" Fininsh Writhing using pen");
    }
}
class Paper{
    public synchronized  void writeWithPenAndPaper(Pen pen)
    {
        System.out.println(Thread.currentThread().getName()+" is Using Paper"+this+" is trying to use pen "+pen);
        pen.finishWriting();

    }
    public synchronized  void finishWriting(){
        System.out.println(Thread.currentThread().getName()+" Fininsh Writhing using paper");
    }
}