package me.nerminsehic.item41;

import java.util.function.DoubleBinaryOperator;

// Enum with function object fields & constant-specific behaviour
public enum Operation {
    PLUS("+", Double::sum),
    MINUS("-", (a, b) -> a - b),
    TIMES("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b);

    private final String symbol;
    private final DoubleBinaryOperator op;
    
    Operation(String symbol, DoubleBinaryOperator op) {
        this.symbol = symbol;
        this.op = op;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public double apply(double a, double b) {
        return op.applyAsDouble(a, b);
    }
}
