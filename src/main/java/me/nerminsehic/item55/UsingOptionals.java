package me.nerminsehic.item55;

import java.util.List;

class Toy implements Comparable<Toy> {

    private final String name;

    public Toy(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Toy o) {
        return name.compareTo(o.name);
    }

    public String getName() {
        return name;
    }
}

class TemperTantrumException extends RuntimeException {

}

/**
 * If a method returns an optional, the client gets to choose what action to take
 * if the method can't return a value. You can specify a default value.
 */
public class UsingOptionals {
    public static void main(String[] args) {
        List<String> words = List.of(
                "nermin",
                "leah",
                "emir"
        );

        // Using an optional to provide a chosen default value.
        String lastWordInLexicon = Optionals.max(words).orElse("No words...");


        List<Toy> toys = List.of(
          new Toy("Woody"),
          new Toy("Buzz"),
          new Toy("Potato Head")
        );

        /*
            You can throw an exception that is appropriate. Note that we pass
            in an exception factory rather than an actual exception. This avoids
            the expense of creating the exception unless it will actually be thrown.
         */
        Toy myToy = Optionals.max(toys).orElseThrow(TemperTantrumException::new);


    }
}
