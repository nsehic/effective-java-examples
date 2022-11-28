package me.nerminsehic.item41;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class Anagrams {
    public static void main(String[] args) {
        File dictionary = new File(args[0]);
        int minGroupSize = Integer.parseInt(args[1]);

        Map<String, Set<String>> groups = new HashMap<>();
        try (Scanner s = new Scanner(dictionary)) {
            while (s.hasNext()) {
                String word = s.next();
                groups.computeIfAbsent(alphabetize(word), (unused) -> new TreeSet<>()).add(word);
            }
        } catch (IOException e) {
            System.out.printf("IOException: %s%n", e.getMessage());
        }
    }

    // Overuse of streams - don't do this!
    public static void overusedStreams(String[] args) {
        Path dictionary = Paths.get(args[0]);
        int minGroupSize = Integer.parseInt(args[1]);

        try (Stream<String> words = Files.lines(dictionary)) {
            words.collect(
                            groupingBy(
                                    word -> word.chars().sorted().collect(
                                            StringBuilder::new,
                                            (sb, c) -> sb.append((char) c),
                                            StringBuilder::append).toString()
                            )
                    )
                    .values().stream()
                    .filter(group -> group.size() >= minGroupSize)
                    .map(group -> group.size() + ": " + group)
                    .forEach(System.out::println);
        } catch (IOException e) {
            System.out.printf("IOException: %s%n", e.getMessage());
        }
    }

    // Tasteful use of streams enhances clarity and conciseness
    public static void tastefulUseOfStreams(String[] args) {
        Path dictionary = Paths.get(args[0]);
        int minGroupSize = Integer.parseInt(args[1]);

        try(Stream<String> words = Files.lines(dictionary)) {
            words.collect(groupingBy(Anagrams::alphabetize))
                    .values().stream()
                    .filter(group -> group.size() >= minGroupSize)
                    .forEach(g -> System.out.println(g.size() + ": " + g));

        } catch(IOException e) {
            System.out.printf("IOException: %s%n", e.getMessage());
        }
    }

    private static String alphabetize(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
}
