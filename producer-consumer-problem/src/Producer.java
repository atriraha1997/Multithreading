public class Producer implements Runnable{
    MessagingQueue messagingQueue;
    public Producer(MessagingQueue messagingQueue){
        this.messagingQueue = messagingQueue;
    }
    @Override
    public void run() {
        int item = 0;
        while(true){
            messagingQueue.setItem(item++);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
