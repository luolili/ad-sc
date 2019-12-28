package com.luo.ad.lamda.stream;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamCreator {

    @Test
    public void byVal() {
        Stream<Integer> stream = Stream.of(1, 2, 3);
        stream.forEach(System.out::println);
    }

    @Test
    public void byArr() {
        int[] arr = {1, 2, 3};
        IntStream stream = Arrays.stream(arr);
        stream.forEach(System.out::println);
    }

    @Test
    public void byFile() throws Exception {
        Stream<String> stream = Files.lines(Paths.get(""));
        stream.forEach(System.out::println);
    }

    //无限流
    @Test
    public void byFunc() throws Exception {
        //Stream<Integer> stream = Stream.iterate(0, n -> n + 2);
        Stream<Double> stream = Stream.generate(Math::random);
        stream.forEach(System.out::println);
    }
}
