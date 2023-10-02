public class Consumer implements Runnable{
    MessagingQueue messagingQueue;
    public Consumer(MessagingQueue messagingQueue){
        this.messagingQueue = messagingQueue;
    }
    @Override
    public void run() {
        while(true){
            messagingQueue.getItem();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
