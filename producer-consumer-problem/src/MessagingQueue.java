import java.util.LinkedList;
import java.util.Queue;

public class MessagingQueue {
    private Queue<Integer> queue;
    boolean produceFlag = true;

    public MessagingQueue(){
        queue = new LinkedList<>();
    }

    public synchronized void getItem() {
        while (produceFlag || queue.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Integer item = queue.poll();
        System.out.println("Consume: "+item);
        produceFlag=true;
        notify();
    }

    public synchronized void setItem(Integer item) {
        while (!produceFlag){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Produce: "+item);
        this.queue.offer(item);
        produceFlag=false;
        notify();
    }

}
