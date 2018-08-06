package com.knoldus;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.io.*;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Ques3 {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/main/resources/book.txt");
        Map<String, Long> wordCount = Files.lines(path).flatMap(line -> Arrays.stream(line.trim().split(" ")))
                .map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase().trim())
                .filter(word -> word.length() > 0)
                .map(word -> new AbstractMap.SimpleEntry<>(word, 1))
                .collect(groupingBy(AbstractMap.SimpleEntry::getKey, counting()));

        wordCount.forEach((k, v) -> System.out.println(String.format("%s -- %d", k, v)));

    }
}
