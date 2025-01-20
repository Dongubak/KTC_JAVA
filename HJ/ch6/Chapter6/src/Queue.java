class Queue {
    private char q[];
    private int front, rear;

    Queue(int size) {
        q = new char[size];
        front = 0;
        rear = 0;
    }

    void put(char ch) {
        if(rear == q.length) {
            System.out.println("Queue is full");
            return;
        }
        q[rear++] = ch;
    }

    char get() {
        if(front == rear) {
            System.out.println("Queue is empty");
            return (char)0;
        }
        return q[front++];
    }
}