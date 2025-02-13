
interface IGenQ<T> {
    void put(T ch) throws QueueFullException;  
    T get() throws QueueEmptyException;
}

class QueueFullException extends Exception {
    int size;

    QueueFullException(int s) {
        size = s;
    }

    public String toString() {
        return "\n큐가 가득 찼습니다. 최대 크기는 " + size;
    }
}

class QueueEmptyException extends Exception {
    public String toString() {
        return "\n큐가 비어 있습니다.";
    }
}

class GenQueue<T> implements IGenQ<T> {
    private T[] q;
    private int putloc, getloc;

    public GenQueue(T[] aRef) {
        q = aRef;
        putloc = getloc = 0;
    }

    public void put(T obj) throws QueueFullException {
        if (putloc == q.length)
            throw new QueueFullException(q.length);
        q[putloc++] = obj;
    }

    public T get() throws QueueEmptyException {
        if (getloc == putloc)
            throw new QueueEmptyException();
        return q[getloc++];
    }
}

class GenQDemo {
    public static void main(String args[]) {
        Integer iStore[] = new Integer[10];
        GenQueue<Integer> q = new GenQueue<Integer>(iStore);
        Integer iVal;
        System.out.println("정수 큐 시연.");
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(i + "를 큐에 추가.");
                q.put(i);
            }
        } catch (QueueFullException exc) {
            System.out.println(exc);
        }
        System.out.println();

        try {
            for (int i = 0; i < 5; i++) {
                System.out.print("큐에서 정수 꺼내기: ");
                iVal = q.get();
                System.out.println(iVal);
            }
        } catch (QueueEmptyException exc) {
            System.out.println(exc);
        }
        System.out.println();

        Double dStore[] = new Double[10];
        GenQueue<Double> q2 = new GenQueue<Double>(dStore);
        Double dVal;
        System.out.println("실수 큐 시연.");
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println((double) i / 2 + "를 큐에 추가.");
                q2.put((double) i / 2);
            }
        } catch (QueueFullException exc) {
            System.out.println(exc);
        }
        System.out.println();

        try {
            for (int i = 0; i < 5; i++) {
                System.out.print("큐에서 실수 꺼내기: ");
                dVal = q2.get();
                System.out.println(dVal);
            }
        } catch (QueueEmptyException exc) {
            System.out.println(exc);
        }
    }
}
