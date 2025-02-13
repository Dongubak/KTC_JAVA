package c11e12;

public class SynchronizedQueue {
    char q[];

    int putloc;
    int getloc;

    SynchronizedQueue(int size) {
        q = new char[size]; // Allocate memory for the queue.
        putloc = getloc = 0;
    }

    public synchronized void put(char ch) {
        if(putloc==q.length) {
            System.out.println(" - Queue is full.");
            return;
        }
        q[putloc++] = ch;
    }

    public synchronized char get() {
        if(getloc == putloc) {
            System.out.println(" - Queue is empty.");
            return (char) 0;
        }
        return q[getloc++];
    }
}
