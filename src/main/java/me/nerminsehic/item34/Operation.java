package me.nerminsehic.item34;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// constant-specific method implementations
public enum Operation {
    PLUS("+") { public double apply(double x, double y) { return x + y; }},
    MINUS("-") { public double apply(double x, double y) { return x - y; }},
    TIMES("*") { public double apply(double x, double y) { return x * y; }},
    DIVIDE("/") { public double apply(double x, double y) { return x / y; }};

    private final String symbol;
    private static final Map<String, Operation> stringToEnum =
            Stream.of(values()).collect(Collectors.toMap(Object::toString, e -> e));

    /*
    * If you override the toString method, you should also consider writing a fromString method
    * to translate the custom string representation to thr corresponding enum.
    * */
    public static Optional<Operation> fromString(String symbol) {
        return Optional.ofNullable(stringToEnum.get(symbol));
    }

    Operation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public abstract double apply(double x, double y);
}

class OperationClient {
    /*
    * Switches on enums are good for augmenting types with constant-specific behaviour.
    * In this example, we have a method that is inversion an Operation.
    * */
    public static Operation inverse(Operation op) {
        switch(op) {
            case PLUS -> {
                return Operation.MINUS;
            }
            case MINUS -> {
                return Operation.PLUS;
            }
            case TIMES -> {
                return Operation.DIVIDE;
            }
            case DIVIDE -> {
                return Operation.TIMES;
            }
            default -> throw new AssertionError("Unknown op: " + op);
        }
    }
}
