package ticktock;

public class ThreadCom {
    static final int SECONDS_TO_RUN = 5;
    public static void main(String args[]) {
        TickTock tt = new TickTock();
        MyThread mt1 = new MyThread("Tick", tt, SECONDS_TO_RUN);
        MyThread mt2 = new MyThread("Tock", tt, SECONDS_TO_RUN);
        mt1.StartThread();
        mt2.StartThread();
        try{
            mt1.thrd.join();
            mt2.thrd.join();
        } catch(InterruptedException exc) {
            System.out.println("Main thread interrupted.");
        }
    }
}
