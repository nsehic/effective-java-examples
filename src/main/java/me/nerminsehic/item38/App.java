package me.nerminsehic.item38;

public class App {
    public static void main(String[] args) {
        double x = 15.0;
        double y = 21.5;
        test(ExtendedOperation.class, x, y);
    }

    private static <T extends Enum<T> & Operation> void test(Class<T> opEnumType, double x, double y) {
        for(Operation op: opEnumType.getEnumConstants())
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
    }
}
