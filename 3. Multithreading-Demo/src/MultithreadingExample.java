public class MultithreadingExample extends Thread implements Runnable {
    private int currentThread;

    public MultithreadingExample() {
    }

    public MultithreadingExample(int currentThread) {
        this.currentThread = currentThread;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(i + " current thread:" + currentThread);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }
        }
    }
}
