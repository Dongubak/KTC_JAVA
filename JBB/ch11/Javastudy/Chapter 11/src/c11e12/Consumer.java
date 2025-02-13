package c11e12;


public class Consumer implements Runnable {

    private SynchronizedQueue queue;
    private int count;

    public Consumer(SynchronizedQueue aQueue) {
        queue = aQueue;
    }

    @Override
    public void run() {
        count = 0;
        char c;
        while (count < 52) {
            c = queue.get();
            if(c != (char) 0) {
                count++;
                System.out.print(c);
            }
        }
        System.out.println();
    }
}