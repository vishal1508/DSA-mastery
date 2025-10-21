package multithread.part1;
/*
    Q3.Even-Odd Number Printing using synchronized
    Two threads print numbers up to N alternately (even and odd) using synchronized and wait/notify.
*/
public class MultiThreadSynchronizeWaitNotifyExample {
    public static void main(String[] args) {
        EvenOdd evenOdd = new EvenOdd(10);
        Runnable evenTask = new Runnable() {
            @Override
            public void run() {
                evenOdd.evenTurn();
            }
        };
        Runnable oddTask = new Runnable() {
            @Override
            public void run() {
                evenOdd.oddTurn();
            }
        };
        Thread t1 = new Thread(evenTask, "Thread-1 (Even) ");
        Thread t2 = new Thread(oddTask, "Thread-2 (Odd): ");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

class EvenOdd {
    int num = 0;
    private int limit = 10;
    boolean isEvenTurn = true;

    public EvenOdd(int limit) {
        this.limit = limit;
    }

    public synchronized void evenTurn() {
        while (num < limit) {
            while (!isEvenTurn) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println(Thread.currentThread().getName() + " is interrupted");
                }
            }
            System.out.println(Thread.currentThread().getName() + num);
            this.num++;
            isEvenTurn = false;
            notifyAll();
        }
    }

    public synchronized void oddTurn() {
        while (num < limit) {
            while (isEvenTurn) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println(Thread.currentThread().getName() + " is interrupted");
                }
            }
            System.out.println(Thread.currentThread().getName() + num);
            this.num++;
            isEvenTurn = true;
            notifyAll();

        }
    }

}
