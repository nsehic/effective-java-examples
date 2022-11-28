package me.nerminsehic.item39;

import java.lang.annotation.*;

// Repeatable annotation type
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(ExceptionTestContainer.class)
public @interface RepeatableExceptionTest {
    Class<? extends Exception> value();
}
