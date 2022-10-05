package ThreadLocal;

public class ThreadLocal {
    public static void main(String[] args) {

        java.lang.ThreadLocal<String> threadLocal =
                java.lang.ThreadLocal.withInitial(() -> String.valueOf(System.currentTimeMillis()));


        Thread thread1 = new Thread(() -> {
            threadLocal.set("Thread 1");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(threadLocal.get());
        });

        Thread thread2 = new Thread(() -> {
            threadLocal.set("Thread 2");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(threadLocal.get());
        });

        thread1.start();
        thread2.start();
    }
}
