package me.nerminsehic.item41;

import java.math.BigInteger;
import java.util.stream.Stream;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TWO;

public class Mersenne {
    private static Stream<BigInteger> primes() {
        return Stream.iterate(TWO, BigInteger::nextProbablePrime);
    }

    public static void main(String[] args) {
        primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(20)
                .forEach(System.out::println);
    }
}
