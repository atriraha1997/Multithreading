public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        MessagingQueue mq = new MessagingQueue();
        Producer producer = new Producer(mq);
        Consumer consumer = new Consumer(mq);
        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);
        producerThread.start();
        consumerThread.start();
    }
}