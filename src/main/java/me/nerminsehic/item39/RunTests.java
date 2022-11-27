package me.nerminsehic.item39;

import java.lang.reflect.*;

// Program to process marker annotations
public class RunTests {

    public static void main(String[] args) throws Exception {
        int tests = 0;
        int passed = 0;
        String classToTest = "me.nerminsehic.item39.Sample2";

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

            if(m.isAnnotationPresent(ExceptionTest.class)) {
                tests++;
                try {
                    m.invoke(null);
                    System.out.printf("Test %s failed: no exception%n", m);
                } catch(InvocationTargetException wrappedExc) {
                    Throwable exc = wrappedExc.getCause();
                    int oldPassed = passed;
                    Class<? extends Throwable>[] excTypes = m.getAnnotation(ExceptionTest.class).value();

                    for(Class<? extends Throwable> excType: excTypes) {
                        if(excType.isInstance(exc)) {
                            passed++;
                            break;
                        }
                    }
                    if(passed == oldPassed)
                        System.out.printf("Test %s failed: %s %n", m, exc);
                } catch(Exception exc) {
                    System.out.println("Invalid @Test: " + m);
                }
            }
        }
        System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
    }
}
