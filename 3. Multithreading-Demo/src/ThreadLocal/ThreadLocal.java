package ThreadLocal;

public class ThreadLocal {
    public static void main(String[] args) {

        java.lang.ThreadLocal<String> threadLocal =
                java.lang.ThreadLocal.withInitial(() -> String.valueOf(System.currentTimeMillis()));


        Thread thread1 = new Thread(() -> {
            threadLocal.set("Thread 1");

            try {

            }
        });

    }
}
