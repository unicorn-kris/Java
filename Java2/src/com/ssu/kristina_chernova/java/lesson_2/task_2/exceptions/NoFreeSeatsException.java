package com.ssu.kristina_chernova.java.lesson_2.task_2.exceptions;

public class NoFreeSeatsException extends CarParkException {
    public NoFreeSeatsException(String transportType) {
        super("Have no seats in " + transportType);
    }
}
