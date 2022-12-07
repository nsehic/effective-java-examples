package me.nerminsehic.item78;

import java.util.concurrent.atomic.AtomicLong;

/*
    Follow the advice in Item 59 and use the AtomicLong, which is part
    of java.util.concurrent.atomic. This package provides primitives for lock-free,
    thread-safe programming on single variables. While volatile provides only the communication
    effects of synchronization, this package also provides atomicity. This is exactly
    what we want for generateSerialNumber, and it is likely to outperform the synchronized version.
 */
public class AtomicSerial {
    // Lock-free synchronization with java.util.concurrent.atomic
    private static final AtomicLong nextSerialNum = new AtomicLong();

    public static long generateSerialNumber() {
        return nextSerialNum.getAndIncrement();
    }
}
