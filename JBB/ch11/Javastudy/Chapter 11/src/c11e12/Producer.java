package c11e12;

public class Producer implements Runnable {

    private SynchronizedQueue queue;

    public Producer(SynchronizedQueue aQueue) {
        queue = aQueue;
    }

    @Override
    public void run() {
        char letter = 'a';
        while (letter <= 'z') {
            queue.put(letter++);
        }
    }
}
