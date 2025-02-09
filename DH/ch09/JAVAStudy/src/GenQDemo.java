// 제네릭 큐 인터페이스
interface IGenQ<T> {
    void put(T ch) throws QueueFullException;  // 큐에 항목을 넣다.
    T get() throws QueueEmptyException;        // 큐에서 항목을 꺼내다.
}

// 큐 가득 참 오류를 위한 예외 클래스
class QueueFullException extends Exception {
    int size;

    QueueFullException(int s) {
        size = s;
    }

    public String toString() {
        return "\n큐가 가득 찼습니다. 최대 크기는 " + size;
    }
}

// 큐 비어 있음 오류를 위한 예외 클래스
class QueueEmptyException extends Exception {
    public String toString() {
        return "\n큐가 비어 있습니다.";
    }
}

// 제네릭 고정 크기 큐 클래스
class GenQueue<T> implements IGenQ<T> {
    private T[] q;  // 큐를 저장할 배열
    private int putloc, getloc;  // put과 get의 인덱스

    // 주어진 배열로 빈 큐를 생성하다.
    public GenQueue(T[] aRef) {
        q = aRef;
        putloc = getloc = 0;
    }

    // 큐에 항목을 넣다.
    public void put(T obj) throws QueueFullException {
        if (putloc == q.length)
            throw new QueueFullException(q.length);
        q[putloc++] = obj;
    }

    // 큐에서 항목을 꺼내다.
    public T get() throws QueueEmptyException {
        if (getloc == putloc)
            throw new QueueEmptyException();
        return q[getloc++];
    }
}

// 제네릭 큐 클래스 시연
class GenQDemo {
    public static void main(String args[]) {
        // 정수 큐 생성
        Integer iStore[] = new Integer[10];
        GenQueue<Integer> q = new GenQueue<Integer>(iStore);
        Integer iVal;
        System.out.println("정수 큐 시연.");
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(i + "를 큐에 추가.");
                q.put(i); // 정수 값을 큐에 추가
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

        // 실수 큐 생성
        Double dStore[] = new Double[10];
        GenQueue<Double> q2 = new GenQueue<Double>(dStore);
        Double dVal;
        System.out.println("실수 큐 시연.");
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println((double) i / 2 + "를 큐에 추가.");
                q2.put((double) i / 2); // 실수 값을 큐에 추가
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
