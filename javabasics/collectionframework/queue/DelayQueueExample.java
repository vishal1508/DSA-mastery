package collectionframework.queue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueExample {
    public static void main(String[] args) throws  InterruptedException {
        // Thread Safe unbounded blocking queue
        // Elements can only be taken from the queue when their delay has expired
        // useful for scheduling task to be executed after a certain delay
        // internally Priority Queue
        DelayQueue<DelayedTask> delayqueue = new DelayQueue<>();
        delayqueue.put(new DelayedTask("Task 1",5,TimeUnit.SECONDS));
        delayqueue.put(new DelayedTask("Task 2",3,TimeUnit.SECONDS));
        delayqueue.put(new DelayedTask("Task 3",10 ,TimeUnit.SECONDS));

        while (!delayqueue.isEmpty()){
            DelayedTask task = delayqueue.take();
            System.out.println("Executer : "+task.getTaskName()+" at "+System.currentTimeMillis());
        }
    }
}

class DelayedTask implements Delayed {
    private final String taskName ;
    private final long startTime;
    DelayedTask(String taskName,long delay, TimeUnit unit){
        this.taskName = taskName;
        this.startTime = System.currentTimeMillis() +  unit.toMillis(delay);
    }
    @Override
    public long getDelay(TimeUnit unit) {
        long remainingTime = startTime - System.currentTimeMillis();
        return unit.convert(remainingTime,TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        if(this.startTime < ((DelayedTask)o).startTime){
            return -1;
        }
        if(this.startTime > ((DelayedTask)o).startTime){
            return 1;
        }
        return 0;
    }

    public String getTaskName() {
        return taskName;
    }

    public long getStartTime() {
        return startTime;
    }
}
