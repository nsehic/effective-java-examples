package me.nerminsehic.item39;

import java.lang.annotation.Repeatable;
import java.lang.reflect.*;

// Program to process marker annotations
public class RunTests {

    public static void main(String[] args) throws Exception {
        int tests = 0;
        int passed = 0;
        String classToTest = "me.nerminsehic.item39.Sample3";

        Class<?> testClass = Class.forName(classToTest);

        for(Method m : testClass.getDeclaredMethods()) {
            if(m.isAnnotationPresent(Test.class)) {
                tests++;
                try {
                    m.invoke(null);
                    passed++;
                } catch(InvocationTargetException wrappedExc) {
                    Throwable exc = wrappedExc.getCause();
                    System.out.println(m + "failed: " + exc);
                } catch(Exception exc) {
                    System.out.println("Invalid @Test: " + m);
                }
            }

            if(m.isAnnotationPresent(RepeatableExceptionTest.class) || m.isAnnotationPresent(ExceptionTestContainer.class)) {
                tests++;
                try {
                    m.invoke(null);
                    System.out.printf("Test %s failed: no exception%n", m);
                } catch(Throwable wrappedExc) {
                    Throwable exc = wrappedExc.getCause();
                    int oldPassed = passed;
                    RepeatableExceptionTest[] excTests = m.getAnnotationsByType(RepeatableExceptionTest.class);

                    for(RepeatableExceptionTest excTest: excTests) {
                        if(excTest.value().isInstance(exc)) {
                            passed++;
                            break;
                        }
                    }

                    if(passed == oldPassed)
                        System.out.printf("Test %s failed: %s %n", m, exc);
                }
            }
        }
        System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
    }
}
