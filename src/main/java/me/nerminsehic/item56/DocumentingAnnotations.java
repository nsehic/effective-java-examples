package me.nerminsehic.item56;

/*
When documenting an annotation type, be sure to document any members as well
as the type itself. Document members with noun phrases, as if they were fields. For the summary description of the type,
use a verb phrase that says what t means when a program element has an annotation of this type.
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates that the annotated method is a test method that
 * must throw the designated exception to pass.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DocumentingAnnotations {

    /**
     * The exception that the annotated test method must throw
     * in order to pass. (The test is permitted to throw any
     * subtype of the type described by this class object).
     */
    Class<? extends Throwable> value();
}
