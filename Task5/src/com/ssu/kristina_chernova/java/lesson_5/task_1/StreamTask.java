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
        List<Integer> evenList = list.stream().filter((n) -> n % 2 == 0).collect(Collectors.toList());// Четные числа
        List<Integer> oddList = list.stream().filter((n) -> n % 2 == 1).collect(Collectors.toList()); // Нечетные числа
        List<Integer> doubleList = list.stream().map((n) -> n * 2).collect(Collectors.toList());// Удвоение всех чисел
        List<Integer> distinctList = list.stream().distinct().collect(Collectors.toList()); // Повторения исчезают
        List<Integer> sortedList = list.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());// По убыванию
        Integer integer = list.stream().mapToInt((s) -> s).sum(); // Сумма
        long timeNotPar = System.currentTimeMillis() - time;

        time = System.currentTimeMillis();
        List<Integer> evenListPar = list.parallelStream().filter((n) -> n % 2 == 0).collect(Collectors.toList());// Четные числа
        List<Integer> oddListPar = list.parallelStream().filter((n) -> n % 2 == 1).collect(Collectors.toList()); // Нечетные числа
        List<Integer> doubleListPar = list.parallelStream().map((n) -> n * 2).collect(Collectors.toList());// Удвоение всех чисел
        List<Integer> distinctListPar = list.parallelStream().distinct().collect(Collectors.toList()); // Повторения исчезают
        List<Integer> sortedListPar = list.parallelStream().sorted(Collections.reverseOrder()).collect(Collectors.toList());// По убыванию
        Integer integerPar = list.parallelStream().mapToInt((s) -> s).sum(); // Сумма
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