package com.ssu.kristina_chernova.java.lesson_5.task_1.exceptions;

public class NoFreeSeatsException extends CarParkException {
    public NoFreeSeatsException(String transportType) {
        super("Have no seats in " + transportType);
    }
}
