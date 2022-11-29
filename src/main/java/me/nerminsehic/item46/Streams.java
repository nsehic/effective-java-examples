package me.nerminsehic.item46;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

    // Uses the streams API but not the paradigm - Don't do this!!!
    public static void badExample() {
        String file = "file";

        Map<String, Long> freq = new HashMap<>();
        try(Stream<String> words = new Scanner(file).tokens()) {
            words.forEach(word -> {
               freq.merge(word.toLowerCase(), 1L, Long::sum);
            });
        }
    }

    // Proper use of streams to initialize a frequency table
    public static void goodExample() {
        String file = "file";
        Map<String, Long> freq;

        try(Stream<String> words = new Scanner(file).tokens()) {
            freq = words.collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));
        }

        List<String> topTen = freq.keySet().stream()
                .sorted(Comparator.comparing(freq::get).reversed())
                .limit(10)
                .toList();
    }
}
