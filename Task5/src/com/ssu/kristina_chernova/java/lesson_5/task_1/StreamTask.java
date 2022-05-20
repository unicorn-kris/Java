package com.ssu.kristina_chernova.java.lesson_5.task_1;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class StreamTask{
    public void streamTask() {
        Stream<Integer> st = Stream.empty();

        List<Integer> list = Stream.generate(() -> new Random().nextInt(1000001)).limit(1000000).collect(Collectors.toList());//Создание

        long time = System.currentTimeMillis();
        Integer evenList = Stream.generate(() -> new Random().nextInt(1000001)).limit(1000000)
                        .filter((n) -> n % 2 == 0)
                        .map((n) -> n * 2)
                .distinct()
                .sorted(Collections.reverseOrder())
                .mapToInt((s) -> s).sum(); // Сумма
        long timeNotPar = System.currentTimeMillis() - time;

        time = System.currentTimeMillis();
        evenList = Stream.generate(() -> new Random().nextInt(1000001)).limit(1000000)
                .parallel()
                .filter((n) -> n % 2 == 0)
                .map((n) -> n * 2)
                .distinct()
                .sorted(Collections.reverseOrder())
                .mapToInt((s) -> s).sum();  // Сумма
        long timePar = System.currentTimeMillis() - time;

        System.out.println("Sub of times: " + (timeNotPar - timePar));
    }
}
class Main {
    public static void main(String[] args) {
//stream task
        StreamTask streamTask = new StreamTask();
        streamTask.streamTask();
    }
}