package ThreadPools;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //Executor
        Executor executor = Executors.newSingleThreadExecutor();

        executor.execute(() -> System.out.println("Hello, world!"));
        executor.execute(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Hello, world 1!");
        });
        executor.execute(() -> System.out.println("Hello, world 2!"));


        //ExecutorService
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<String> future = executorService.submit(() -> "Hello Word!!");

        String result = future.get();
        System.out.println(result);


        //ThreadPoolExecutor with .newFixedThreadPool()
        ThreadPoolExecutor executor1 = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        executor1.submit(() -> {
            Thread.sleep(1000);
            return null;
        });

        //ThreadPoolExecutor with .newCachedThreadPool()
        ThreadPoolExecutor executor2 = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        executor2.submit(() -> {
            Thread.sleep(1000);
            return null;
        });

        //ThreadPoolExecutor with .newSingleThreadExecutor()
        AtomicInteger counter = new AtomicInteger();

        ExecutorService executor3 = Executors.newSingleThreadExecutor();
        executor3.submit(() -> {
            counter.set(1);
        });
        executor3.submit(() -> {
            counter.compareAndSet(1, 2);
        });
    }
}
