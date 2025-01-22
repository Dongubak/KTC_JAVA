package ticktock;


public class TickTock {

    String state;

    synchronized void tick(boolean running) {
        state = "ticked";
        if (!running) {
            notify();
            return;
        }
        System.out.print("Tick ");
        try {
            Thread.sleep(500);
        } catch (InterruptedException exc) {
            System.out.println("Thread interrupted");
        }
        notify();
        try {
            while (state.equals("ticked")) {
                wait();
            }
        } catch (InterruptedException exc) {
            System.out.println("Thread interrupted.");
        }
    }

    synchronized void tock(boolean running) {
        state = "tocked";
        if (!running) {
            notify();
            return;
        }
        System.out.println("Tock");
        try {
            Thread.sleep(500);
        } catch (InterruptedException exc) {
            System.out.println("Thread interrupted");
        }
        notify();
        try {
            while (state.equals("tocked")) {
                wait();
            }
        } catch (InterruptedException exc) {
            System.out.println("Thread interrupted.");
        }
    }

}