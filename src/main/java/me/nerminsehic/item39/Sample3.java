package me.nerminsehic.item39;

// Code containing repeated annotation
public class Sample3 {

    @RepeatableExceptionTest(IndexOutOfBoundsException.class)
    @RepeatableExceptionTest(NullPointerException.class)
    public static void doublyBad() {

    }
}
