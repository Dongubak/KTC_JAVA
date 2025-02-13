package ticktock;

public class MyThread implements Runnable {
    Thread thrd;
    private TickTock ttOb;
    private static int time;

    MyThread(String name, TickTock tt, int time) {
        thrd = new Thread(this, name);
        ttOb = tt;
        this.time = time;
    }

    public void StartThread() {
        thrd.start();
    }

    @Override
    public void run() {
        if(thrd.getName().compareTo("Tick") == 0) {
            for(int i = 0; i < time; i++) {
                ttOb.tick(true);
            }
            ttOb.tick(false);
        } else {
            for(int i = 0; i < time; i++) {
                ttOb.tock(true);
            }
            ttOb.tock(false);
        }
    }

}
