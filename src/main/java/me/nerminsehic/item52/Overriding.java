package me.nerminsehic.item52;

import java.util.List;

class Wine {
    String name() { return "wine"; }
}

class SparklingWine extends Wine {
    @Override
    String name() { return "sparkling wine"; }
}

class Champagne extends SparklingWine {
    @Override
    String name() { return "champagne"; }
}

/**
 * The `name` method is declared in class `Wine` and overridden in subclasses
 * `SparklingWine` and `Champagne`. As you would expect, this program prints out wine, sparkling wine,
 * and champagne, even though the compile-time type of the instance is Wine in each iteration of the loop.
 *
 * The compile-time type of object has no effect on which method is executed when an overridden method is invoked;
 * the "most specific" overriding always gets executed.
 */
public class Overriding {
    public static void main(String[] args) {
        List<Wine> wineList = List.of(
                new Wine(),
                new SparklingWine(),
                new Champagne()
        );

        for(Wine wine: wineList)
            System.out.println(wine.name());
    }
}
