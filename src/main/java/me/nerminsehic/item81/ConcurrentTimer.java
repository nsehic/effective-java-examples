package me.nerminsehic.item81;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

public class ConcurrentTimer {

    // Simple framework for timing concurrent execution
    public static long time(Executor executor, int concurrency, Runnable action) throws InterruptedException {
        CountDownLatch ready = new CountDownLatch(concurrency);
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch done = new CountDownLatch(concurrency);

        for(int i = 0; i < concurrency; i++) {
            executor.execute(() -> {
               ready.countDown(); // Tell timer we're ready
               try {
                   start.await(); // Wait till peers are ready
                   action.run();
               } catch(InterruptedException e) {
                   Thread.currentThread().interrupt();
               } finally {
                   done.countDown();
               }
            });
        }

        ready.await(); // Wait for all workers to be ready
        long startNanos = System.nanoTime();
        start.countDown(); // And they're off
        done.await();
        return System.nanoTime() - startNanos;
    }
}
